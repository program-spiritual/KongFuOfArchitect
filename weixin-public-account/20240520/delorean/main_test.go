/*
**
** delorean tests
** Tests for delorean
**
** Distributed under the COOLER License.
**
** Copyright (c) 2024 IPv6.rs <https://ipv6.rs>
** All Rights Reserved
**
 */

// 包声明，表明该文件属于main包
package main

// 导入的包列表
import (
	"bufio"        // 用于读写缓冲数据
	"bytes"        // 用于处理字节切片
	"encoding/binary" // 用于二进制数据的编码和解码
	"log"          // 用于记录日志
	"net"          // 用于网络接口，如TCP连接
	"runtime"      // 用于获取Go运行时的信息
	"sync"         // 提供基本的同步原语，如互斥锁
	"testing"      // 用于提供测试功能
	"time"         // 用于时间相关功能
)

// init 函数在包初始化时执行，用于设置日志记录器
func init() {
	// 创建一个新的日志记录器，输出设为nullWriter，不会产生实际输出
	logger = log.New(nullWriter{}, "", log.LstdFlags)
}

// createFakeClientHelloPacket 函数用来创建一个伪造的TLS客户端Hello数据包。
func createFakeClientHelloPacket(serverName string) []byte {
	var packet bytes.Buffer // 创建一个用来构建整个数据包的缓冲区

	// 写入TLS记录层的头部信息
	packet.WriteByte(0x16) // 写入ContentType（0x16代表Handshake）
	packet.WriteByte(0x03) // 写入主版本号（0x03代表TLS 1.2）
	packet.WriteByte(0x03) // 写入副版本号（0x03代表TLS 1.2）
	packet.Write([]byte{0x00, 0x00}) // 写入长度占位符（稍后更新）

	var handshake bytes.Buffer // 创建一个用来构建握手协议消息的缓冲区
	handshake.WriteByte(0x01) // 写入HandshakeType（0x01代表ClientHello）
	handshake.Write([]byte{0x00, 0x00, 0x00}) // 写入长度占位符（稍后更新）
	handshake.Write([]byte{0x03, 0x03}) // 写入客户端支持的TLS版本（TLS 1.2）

	// 写入随机数，用于后续的密钥交换过程
	handshake.Write([]byte{
		// 随机生成的32字节数据
	})
	handshake.WriteByte(0x00) // 写入SessionID的长度（0表示没有SessionID）
	handshake.Write([]byte{0x00, 0x04}) // 写入CipherSuite列表的长度
	handshake.Write([]byte{
		// 选择的CipherSuite
	})

	handshake.WriteByte(0x01) // 写入CompressionMethod的长度
	handshake.WriteByte(0x00) // 写入CompressionMethod（0x00代表不压缩）

	var extensions bytes.Buffer // 创建一个用来构建扩展部分的缓冲区
	extensions.Write([]byte{0x00, 0x00}) // 写入扩展部分的长度占位符（稍后更新）

	// 构造Server Name Indication（SNI）扩展
	var sni bytes.Buffer
	sni.Write([]byte{0x00, 0x0c}) // 写入SNI扩展的类型和长度
	sni.WriteByte(0x00) // 写入SNI列表的长度占位符（稍后更新）
	sniName := []byte(serverName) // 将服务器名称转换为字节序列
	binary.Write(&sni, binary.BigEndian, uint16(len(sniName))) // 写入服务器名称的长度
	sni.Write(sniName) // 写入服务器名称
	sniBytes := sni.Bytes()
	extensions.Write([]byte{0x00, 0x0e}) // 写入SNI扩展的类型
	extensions.Write(sniBytes) // 写入SNI扩展的内容

	// 写入其他的扩展（例如Supported Groups和Signature Algorithms）
	extensions.Write([]byte{
		// 扩展的具体内容
	})

	extensionsBytes := extensions.Bytes() // 获取扩展部分的字节序列
	handshake.Write([]byte{0x00, 0x00}) // 写入扩展长度的占位符（稍后更新）
	extensionLengthFieldIndex := handshake.Len() - 2 // 记录扩展长度字段的位置
	handshake.Write(extensionsBytes) // 写入扩展部分
	// 更新扩展部分的实际长度
	binary.BigEndian.PutUint16(handshake.Bytes()[extensionLengthFieldIndex:], uint16(len(extensionsBytes)))

	handshakeBytes := handshake.Bytes() // 获取握手消息的字节序列
	handshakeLength := len(handshakeBytes) - 4 // 计算握手消息的实际长度
	// 更新握手消息的长度字段
	handshakeBytes[1] = byte(handshakeLength >> 16)
	handshakeBytes[2] = byte(handshakeLength >> 8)
	handshakeBytes[3] = byte(handshakeLength)

	packet.Write(handshakeBytes) // 将握手消息写入数据包

	recordLayerLength := len(packet.Bytes()) - 5 // 计算记录层的实际长度
	// 更新记录层长度字段
	packetBytes := packet.Bytes()
	binary.BigEndian.PutUint16(packetBytes[3:], uint16(recordLayerLength))

	log.Printf("Packet Data: %x\n", packet.Bytes()) // 使用十六进制格式打印数据包内容，用于调试
	return packet.Bytes() // 返回构建好的数据包字节序列
}

func TestGetNameFromTLSConnection(t *testing.T) {
	serverName := "www.example.com"
	tlsData := createFakeClientHelloPacket(serverName)

	reader := bufio.NewReaderSize(bytes.NewReader(tlsData), 4096)
	name, err := getNameFromTLSConnection(reader)
	if err != nil {
		t.Fatalf("Expected no error, got %v", err)
	}

	if name != serverName {
		t.Fatalf("Expected %s, got %s", serverName, name)
	}
}

func TestGetNameFromHTTPConnection(t *testing.T) {
	httpData := []byte("GET / HTTP/1.1\r\nHost: example.com\r\n\r\n")
	reader := bufio.NewReader(bytes.NewReader(httpData))

	name, err := getNameFromHTTPConnection(reader)
	if err != nil {
		t.Fatalf("Expected no error, got %v", err)
	}

	expectedName := "example.com"
	if name != expectedName {
		t.Fatalf("Expected %s, got %s", expectedName, name)
	}
}

func BenchmarkGetNameFromTLSConnection(b *testing.B) {
	serverName := "www.example.com"
	tlsData := createFakeClientHelloPacket(serverName)

	for i := 0; i < b.N; i++ {
		reader := bufio.NewReaderSize(bytes.NewReader(tlsData), 4096)
		_, err := getNameFromTLSConnection(reader)
		if err != nil {
			b.Fatalf("Expected no error, got %v", err)
		}
	}
}

// BenchmarkGetNameFromHTTPConnection 是HTTP连接的基准测试函数
func BenchmarkGetNameFromHTTPConnection(b *testing.B) {
	// 构造一个HTTP请求数据
	httpData := []byte("GET / HTTP/1.1\r\nHost: example.com\r\n\r\n")

	// 基准测试循环，b.N是测试框架提供的迭代次数
	for i := 0; i < b.N; i++ {
		// 创建一个新的读取器，以httpData为数据来源
		reader := bufio.NewReader(bytes.NewReader(httpData))
		// 调用getNameFromHTTPConnection函数，尝试从HTTP连接中获取名称
		_, err := getNameFromHTTPConnection(reader)
		if err != nil {
			// 如果发生错误，终止测试并记录错误信息
			b.Fatalf("Expected no error, got %v", err)
		}
	}
}

func StressTestServer(t *testing.T, serverFunc func(stop chan struct{})) {
	var wg sync.WaitGroup
	stop := make(chan struct{})
	serverReady := make(chan struct{})
	var failedConnections int
	var failedConnectionsMutex sync.Mutex

	wg.Add(1)
	go func() {
		defer wg.Done()
		serverFunc(stop)
		close(serverReady)
	}()

	time.Sleep(1 * time.Second)

	clientCount := 1000
	for i := 0; i < clientCount; i++ {
		wg.Add(1)
		go func(clientID int) {
			defer wg.Done()
			for {
				select {
				case <-stop:
					return
				default:
					conn, err := net.Dial("tcp", "127.0.0.1:8080")
					if err != nil {
						t.Logf("Client %d: Failed to connect: %v", clientID, err)
						failedConnectionsMutex.Lock()
						failedConnections++
						failedConnectionsMutex.Unlock()
						return
					}
					conn.Close()
				}
			}
		}(i)
	}

	time.Sleep(10 * time.Second)
	close(stop)
	<-serverReady
	wg.Wait()

	t.Logf("Total failed connections: %d out of %d attempts", failedConnections, clientCount)
}

func TestStressServer(t *testing.T) {
	StressTestServer(t, func(stop chan struct{}) {
		listener, err := net.Listen("tcp", "127.0.0.1:8080")
		if err != nil {
			log.Fatalf("Failed to start server: %v", err)
		}
		defer listener.Close()

		var wg sync.WaitGroup

		for {
			select {
			case <-stop:
				listener.Close()
				wg.Wait()
				return
			default:
				tcpListener := listener.(*net.TCPListener)
				tcpListener.SetDeadline(time.Now().Add(1 * time.Second))
				conn, err := listener.Accept()
				if err != nil {
					if netErr, ok := err.(net.Error); ok && netErr.Timeout() {
						continue
					}
					log.Printf("Failed to accept connection: %v", err)
					continue
				}

				wg.Add(1)
				go func() {
					defer wg.Done()
					handleConnection(conn)
				}()
			}
		}
	})
}

func TestMemoryUsage(t *testing.T) {
	var m runtime.MemStats

	serverName := "www.example.com"
	tlsData := createFakeClientHelloPacket(serverName)

	runtime.ReadMemStats(&m)
	log.Printf("Memory before: Alloc = %v TotalAlloc = %v Sys = %v NumGC = %v", m.Alloc, m.TotalAlloc, m.Sys, m.NumGC)

	for i := 0; i < 1000; i++ {
		reader := bufio.NewReaderSize(bytes.NewReader(tlsData), 4096)
		_, err := getNameFromTLSConnection(reader)
		if err != nil {
			t.Fatalf("Expected no error, got %v", err)
		}
	}

	runtime.ReadMemStats(&m)
	log.Printf("Memory after: Alloc = %v TotalAlloc = %v Sys = %v NumGC = %v", m.Alloc, m.TotalAlloc, m.Sys, m.NumGC)
}

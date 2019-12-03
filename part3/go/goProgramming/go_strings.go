package main

import (
	"fmt"
	"strings"
)

func main() {
	var greeting = "Hello world!"

	fmt.Printf("normal string: ")
	fmt.Printf("%s", greeting)
	fmt.Printf("\n")
	fmt.Printf("hex bytes: ")

	for i := 0; i < len(greeting); i++ {
		fmt.Printf("%x ", greeting[i])
	}

	fmt.Printf("\n")
	const sampleText = "\xbd\xb2\x3d\xbc\x20\xe2\x8c\x98"

	/*q标志转义无法打印的字符，带+标志转义非ascii字符也可以使其明确输出 */
	fmt.Printf("quoted string: ")
	fmt.Printf("%+q", sampleText)
	fmt.Printf("\n")

	//	字符串的长度
	fmt.Printf("String Length is: ")
	fmt.Println(len(greeting))
	// 字符串连接
	greetings := []string{"Hello", "world!"}
	fmt.Println(strings.Join(greetings, " "))
}

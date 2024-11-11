package main // 声明 main 包，表明这是一个可执行程序的入口包

import (
	"context"     // 导入context包，用于创建和管理上下文
	"fmt"         // 导入fmt包，用于格式化输出
	"github.com/go-dew/dew" // 导入dew包，可能是一个第三方库，用于处理命令或事件
)

// HelloAction 结构体定义，代表一个简单的动作，用来向用户打招呼
type HelloAction struct {
	Name string // Name 字段，存储用户名
}

// Validate 方法用于检查HelloAction的Name字段是否有效
func (c HelloAction) Validate(_ context.Context) error {
	if c.Name == "" { // 如果Name字段为空字符串
		return fmt.Errorf("invalid name") // 返回一个错误，表示名字无效
	}
	return nil // 如果名字有效，返回nil表示无错误
}

// HelloHandler 结构体定义，没有字段
type HelloHandler struct{}

// HandleHelloAction 是HelloHandler的方法，处理HelloAction
func (h *HelloHandler) HandleHelloAction(ctx context.Context, cmd *HelloAction) error {
	println(fmt.Sprintf("Hello, %s!", cmd.Name)) // 输出Hello，后跟用户的名字
	return nil // 返回nil，表示处理成功，没有错误
}

func main() {
	// 初始化命令总线
	bus := dew.New()

	// 注册处理HelloAction的处理器
	bus.Register(new(HelloHandler))

	// 备选方法：可以使用HandlerFunc来注册处理器
	// bus.Register(dew.HandlerFunc[HelloAction](func(ctx context.Context, cmd *HelloAction) error {
	//     println(fmt.Sprintf("Hello, %s!", cmd.Name)) // 输出Hello，后跟用户的名字
	//     return nil // 返回nil，表示处理成功，没有错误
	// }))

	// 分发动作，创建一个HelloAction并设置名字为"Dew"
	_ = dew.Dispatch(context.Background(), dew.NewAction(bus, &HelloAction{Name: "Dew"}))
}

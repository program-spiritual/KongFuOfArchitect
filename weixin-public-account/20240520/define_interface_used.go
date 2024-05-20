// 定义一个结构体MyAction
type MyAction struct {
Amount int // Amount字段，类型为int
}

// Validate是MyAction的方法，它实现了Action接口的Validate方法
func (a *MyAction) Validate(ctx context.Context) error {
if a.Amount <= 0 { // 如果Amount字段小于或等于0
return fmt.Errorf("amount must be greater than zero") // 返回一个错误，提示金额必须大于0
}
return nil // 如果没有错误，返回nil
}

// 定义一个结构体MyQuery
type MyQuery struct {
AccountID string // AccountID字段，类型为string
}

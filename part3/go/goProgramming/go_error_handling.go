package main

import (
	"errors"
	"fmt"
	"math"
)

//Go编程提供了一个非常简单的错误处理框架，具有以下声明的内置错误接口类型-
//type error interface {
//	Error() string
//}

//函数通常返回错误作为最后的返回值。使用errors.New构造基本错误消息，如下所示：

//func Sqrt(value float64)(float64, error) {
//	if(value < 0){
//		return 0, errors.New("Math: negative number passed to Sqrt")
//	}
//	return math.Sqrt(value), nil
//}

func Sqrt(value float64) (float64, error) {
	if value < 0 {
		return 0, errors.New("Math: negative number passed to Sqrt")
	}
	return math.Sqrt(value), nil
}
func main() {
	result, err := Sqrt(-1)

	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(result)
	}

	result, err = Sqrt(9)

	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(result)
	}
}

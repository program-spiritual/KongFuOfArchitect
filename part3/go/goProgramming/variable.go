package main

import "fmt"

func main() {
	//var i, j, k int;
	//var c, ch byte;
	//var f, salary float32;
	//d = 42;

	var x float64
	x = 20.0
	fmt.Println(x)
	fmt.Printf("x is of type %T\n", x)
	var y int

	fmt.Println(y)
	fmt.Printf("y is of type %T\n", y)
	// 混合变量生声明

	var a, b, c = 3, 4, "foo"
	fmt.Printf("a is of type %T\n", a)
	fmt.Printf("b is of type %T\n", b)
	fmt.Printf("c is of type %T\n", c)

	//	您可以使用const前缀来声明具有特定类型的常量，如下所示-

	const LENGTH int = 10
	const WIDTH int = 5
	var area int

	area = LENGTH * WIDTH
	fmt.Printf("value of area : %d", area)
}

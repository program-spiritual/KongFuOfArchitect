package main

import "fmt"

// global variable
var g int

func main() {
	/* local variable declaration */
	var a, b int

	/* actual initialization */
	a = 10
	b = 20
	//c = a + b
	g = a + b
	fmt.Printf("value of a = %d, b = %d and g = %d\n", a, b, g)

	//程序的局部变量和全局变量可以具有相同的名称，但是函数内局部变量的值优先
}

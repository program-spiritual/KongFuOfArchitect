package main

import "fmt"

//Go Slice是Go Array的抽象。
//Go Array允许您定义可容纳相同种类的多个数据项的变量，
//但是它不提供任何内置方法来动态增加其大小或获取其自身的子数组。
//切片克服了此限制。它提供了Array所需的许多实用程序功能，并广泛用于Go编程中。
func main() {
	var numbers = make([]int, 3, 5)
	printSlice(numbers)
}

func printSlice(x []int) {
	fmt.Printf("len=%d cap=%d slice=%v\n", len(x), cap(x), x)
}

package main

import "fmt"

const MAX int = 3

func main() {
	//该示例使用3个整数的数组
	a := []int{10, 100, 200}
	var i int
	//将ptr声明为MAX个整数指针的数组。因此，ptr中的每个元素现在都拥有一个指向int值的指针。
	var ptr [MAX]*int

	for i = 0; i < MAX; i++ {
		ptr[i] = &a[i] /* assign the address of integer. */
	}
	for i = 0; i < MAX; i++ {
		fmt.Printf("Value of a[%d] = %d\n", i, *ptr[i])
	}

}

package main

import "fmt"

func main() {
	//作为指针的指针的变量必须这样声明。这是通过在其名称前面放置一个额外的星号来完成的
	//var ptr **int;
	//当指向指针的指针间接指向目标值时，访问该值需要两次应用星号运算符
	var a int
	var ptr *int
	var pptr **int

	a = 3000

	/* take the address of var */
	ptr = &a

	/* take the address of ptr using address of operator & */
	pptr = &ptr

	/* take the value using pptr */
	fmt.Printf("Value of a = %d\n", a)
	fmt.Printf("Value available at *ptr = %d\n", *ptr)
	fmt.Printf("Value available at **pptr = %d\n", **pptr)
}

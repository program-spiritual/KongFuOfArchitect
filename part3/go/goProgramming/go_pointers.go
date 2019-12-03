package main

import "fmt"

func main() {
	//var a int = 10
	//fmt.Printf("Address of a variable: %x\n", &a  )
	//不同数据类型的指针之间的唯一区别是指针指向的变量或常量的数据类型。
	var a int = 20 /* actual variable declaration */
	var ip *int    /* pointer variable declaration */

	ip = &a /* store address of a in pointer variable*/
	//	（a）我们定义指针变量，（b）将变量的地址分配给指针，并且（c）访问指针变量中存储的地址处的值。

	fmt.Printf("Address of a variable: %x\n", &a)

	/* address stored in pointer variable */
	fmt.Printf("Address stored in ip variable: %x\n", ip)

	/* access the value using the pointer */
	fmt.Printf("Value of *ip variable: %d\n", *ip)
	//如果您没有要分配的确切地址，则Go编译器将Nil值分配给指针变量。
	//这是在变量声明时完成的。分配为nil的指针称为nil指针。
	//nil指针是在几个标准库中定义的值为零的常量。考虑以下程序
	var ptr *int

	fmt.Printf("The value of ptr is : %x\n", ptr)
	//在大多数操作系统上，不允许程序访问地址0处的内存，
	//因为该内存是由操作系统保留的。
	//但是，存储器地址0具有特殊的意义。
	//如果指针包含nil（零）值，则假定该指针不指向任何内容。
	if ptr != nil {

	} /* succeeds if p is not nil */
	if ptr == nil {

	} /* succeeds if p is null */
}

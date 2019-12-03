package main

import "fmt"

//定义的方式
//type struct_variable_type struct {
//	member definition;
//	member definition;
//	...
//	member definition;
//}
type Book struct {
	title   string
	author  string
	subject string
	book_id int
}

func main() {
	//Go数组可让您定义可容纳相同种类的多个数据项的变量。
	//结构是Go编程中可用的另一种用户定义的数据类型，
	//它允许您组合不同种类的数据项。
	//结构用于表示记录。假设您想跟踪图书馆中的书籍。您可能要跟踪每本书的以下属性-
	// - Title
	// - Author
	// - Subject
	// - Book ID
	//定义结构类型后，即可使用以下语法将其用于声明该类型的变量。
	//variable_name := structure_variable_type {value1, value2...valuen}
	var Book1 Books /* Declare Book1 of type Book */
	var Book2 Books /* Declare Book2 of type Book */

	/* book 1 specification */
	Book1.title = "Go Programming"
	Book1.author = "Mahesh Kumar"
	Book1.subject = "Go Programming Tutorial"
	Book1.book_id = 6495407

	/* book 2 specification */
	Book2.title = "Telecom Billing"
	Book2.author = "Zara Ali"
	Book2.subject = "Telecom Billing Tutorial"
	Book2.book_id = 6495700

	/* print Book1 info */
	fmt.Printf("Book 1 title : %s\n", Book1.title)
	fmt.Printf("Book 1 author : %s\n", Book1.author)
	fmt.Printf("Book 1 subject : %s\n", Book1.subject)
	fmt.Printf("Book 1 book_id : %d\n", Book1.book_id)

	/* print Book2 info */
	fmt.Printf("Book 2 title : %s\n", Book2.title)
	fmt.Printf("Book 2 author : %s\n", Book2.author)
	fmt.Printf("Book 2 subject : %s\n", Book2.subject)
	fmt.Printf("Book 2 book_id : %d\n", Book2.book_id)
}

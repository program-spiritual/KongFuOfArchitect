package main

//Go编程提供了另一种称为接口的数据类型，它表示一组方法签名。
//struct数据类型将这些接口实现为具有接口的方法签名的方法定义。

/* define an interface */
//type interface_name interface {
//	method_name1 [return_type]
//method_name2 [return_type]
//method_name3 [return_type]
//...
//method_namen [return_type]
//}

/* define a struct */
//type struct_name struct {
//	/* variables */
//}

/* implement interface methods*/
//func (struct_name_variable struct_name) method_name1() [return_type] {
//	/* method implementation */
//}
//...
//func (struct_name_variable struct_name) method_namen() [return_type] {
//	/* method implementation */
//}

import (
	"fmt"
	"math"
)

/* define an interface */
type Shape interface {
	area() float64
}

/* define a circle */
type Circle struct {
	x, y, radius float64
}

/* define a rectangle */
type Rectangle struct {
	width, height float64
}

/* define a method for circle (implementation of Shape.area())*/
func (circle Circle) area() float64 {
	return math.Pi * circle.radius * circle.radius
}

/* define a method for rectangle (implementation of Shape.area())*/
func (rect Rectangle) area() float64 {
	return rect.width * rect.height
}

/* define a method for shape */
func getArea(shape Shape) float64 {
	return shape.area()
}

func main() {
	circle := Circle{x: 0, y: 0, radius: 5}
	rectangle := Rectangle{width: 10, height: 5}

	fmt.Printf("Circle area: %f\n", getArea(circle))
	fmt.Printf("Rectangle area: %f\n", getArea(rectangle))
}

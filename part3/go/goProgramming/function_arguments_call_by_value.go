package main

import "fmt"

func main() {
	/* local variable definition */
	var a int = 100
	var b int = 200

	fmt.Printf("Before swap, value of a : %d\n", a)
	fmt.Printf("Before swap, value of b : %d\n", b)

	/* calling a function to swap the values */
	swap2(a, b)

	fmt.Printf("After swap, value of a : %d\n", a)
	fmt.Printf("After swap, value of b : %d\n", b)
}
func swap2(x, y int) int {
	var temp int

	temp = x /* save the value of x */
	x = y    /* put y into x */
	y = temp /* put temp into y */

	return temp
}

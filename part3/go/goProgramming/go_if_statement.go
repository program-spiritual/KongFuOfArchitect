package main

import "fmt"

func main() {
	/* local variable definition */
	var a int = 10

	/* check the boolean condition using if statement */
	if a < 20 {
		/* if condition is true then print the following */
		fmt.Printf("a is less than 20\n")
	}
	fmt.Printf("value of a is : %d\n", a)
}

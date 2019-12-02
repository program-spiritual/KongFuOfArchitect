package main

import "fmt"

func main() {
	/* local variable definition */
	var a int = 10

	/* do loop execution */
	for a < 20 {
		if a == 15 {
			/* skip the iteration */
			a = a + 1
			continue
		}
		fmt.Printf("value of a: %d\n", a)
		a++
	}
}

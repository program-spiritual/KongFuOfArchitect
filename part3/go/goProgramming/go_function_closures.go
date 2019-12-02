package main

import "fmt"

func getSequence() func() int {
	i := 0
	return func() int {
		i += 1
		return i
	}
}

func main() {
	/* nextNumber is now a function with i as 0 */
	nextNumber := getSequence()

	/* invoke nextNumber to increase i by 1 and return the same */
	fmt.Println(nextNumber())
	fmt.Println(nextNumber())
	fmt.Println(nextNumber())

	/* create a new sequence and see the result, i is 0 again*/
	nextNumber1 := getSequence()
	fmt.Println(nextNumber1())
	fmt.Println(nextNumber1())
}

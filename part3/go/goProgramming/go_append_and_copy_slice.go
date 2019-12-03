package main

import "fmt"

func main() {
	var numbers []int
	printSlice(numbers)

	/* append allows nil slice */
	numbers = append(numbers, 0)
	printSlice(numbers)

	/* add one element to slice*/
	numbers = append(numbers, 1)
	printSlice(numbers)

	/* add more than one element at a time*/
	numbers = append(numbers, 2, 3, 4)
	printSlice(numbers)

	/* create a slice numbers1 with double the capacity of earlier slice*/
	numbers1 := make([]int, len(numbers), (cap(numbers))*2)

	/* copy content of numbers to numbers1 */
	copy(numbers1, numbers)
	printSlice(numbers1)
}
func printSlice(x []int) {
	fmt.Printf("len=%d cap=%d slice=%v\n", len(x), cap(x), x)
}

package main

import "fmt"

func getAverage(arr []int, size int) float32 {
	var i, sum int
	var avg float32

	for i = 0; i < size; i++ {
		sum += arr[i]
	}

	avg = float32(sum / size)
	return avg
}
func main() {
	/* an int array with 5 elements */
	var balance = []int{1000, 2, 3, 17, 50}
	var avg float32

	/* pass array as an argument */
	avg = getAverage(balance, 5)

	/* output the returned value */
	fmt.Printf("Average value is: %f ", avg)
}

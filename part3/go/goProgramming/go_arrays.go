package main

import "fmt"

func main() {
	//var balance = []float32{1000.0, 2.0, 3.4, 7.0, 50.0}
	//	获取数组元素
	//	 salary := balance[1]
	var n [10]int /* n is an array of 10 integers */
	var i, j int

	/* initialize elements of array n to 0 */
	for i = 0; i < 10; i++ {
		n[i] = i + 100 /* set element at location i to i + 100 */
	}

	/* output each array element's value */
	for j = 0; j < 10; j++ {
		fmt.Printf("Element[%d] = %d\n", j, n[j])
	}
}

package main

import "fmt"

func swap(x, y string) (string, string) {
	return y, x
}
func main() {
	a, b := swap("Mahesh", "Kumar")
	fmt.Println(a, b)
}

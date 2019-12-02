package main

import (
	"fmt"
	"math"
)

func main() {
	/* declare a function variable */
	getSquareRoot := func(x float64) float64 {
		return math.Sqrt(x)
	}

	/* use the function */
	fmt.Println(getSquareRoot(9))
}

package main

import "fmt"

func main() {
	a := [3][4]int{
		{0, 1, 2, 3},   /*  initializers for row indexed by 0 */
		{4, 5, 6, 7},   /*  initializers for row indexed by 1 */
		{8, 9, 10, 11}, /*  initializers for row indexed by 2 */
	}
	fmt.Print(a)

	//	访问二维数组
	val := a[2][3]
	fmt.Print(val)

	//	 嵌套循环处理二维数组
	/* an array with 5 rows and 2 columns*/
	var b = [5][2]int{{0, 0}, {1, 2}, {2, 4}, {3, 6}, {4, 8}}
	var i, j int

	/* output each array element's value */
	for i = 0; i < 5; i++ {
		for j = 0; j < 2; j++ {
			fmt.Printf("b[%d][%d] = %d\n", i, j, b[i][j])
		}
	}
}

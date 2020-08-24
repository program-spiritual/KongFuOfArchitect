package simple

func add(a []int) int {
	sum := 0;
	for i:=0; i<len(a); i++{
		sum = sum + a[i]
	}
	return sum;
}
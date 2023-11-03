fn factorial(n u32) u32 {
	if dump(n <= 1) {
		return dump(1)
	}
	return dump(n * factorial(n - 1))
}

println(factorial(5))

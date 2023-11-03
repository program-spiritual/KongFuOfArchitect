fn expensive_computing(i int) int {
	return i * i
}

fn main() {
	mut threads := []thread int{}
	for i := 0; i < 100; i++ {
		threads << spawn expensive_computing(i)
	}
	// join all threads
	r := threads.wait()
	println('all jobs finished: ${r}')
}

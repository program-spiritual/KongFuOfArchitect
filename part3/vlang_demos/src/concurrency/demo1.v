import math

fn p(a f64, b f64) { // ordinary function without return value
	c := math.sqrt(a * a + b * b)
	println(c)
}

fn main() {
	println('start')
	h := go p(3, 4)
	// p will be run in parallel thread
	// It can also be written as follows
	// spawn fn (a f64, b f64) {
	// 	c := math.sqrt(a * a + b * b)
	// 	println(c)
	// }(3, 4)
	// p() runs in parallel thread
	h.wait()
	// p() has definitely finished
}

// This approach can also be used to get a return value from a function that is run in a parallel thread. There is no need to modify the function itself to be able to call it concurrently.
//
import math

fn get_hypot(a f64, b f64) f64 {
	return math.sqrt(a * a + b * b)
}

fn main() {
	g := spawn get_hypot(54.060, 2.08) //  spawn thread and get handle to it
	h1 := get_hypot(2.32, 16.74) // do some other calculation here
	h2 := g.wait() // get result from spawned thread
	println('Results ${h1} and ${h2}')
}

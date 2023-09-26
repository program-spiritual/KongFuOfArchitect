[translated]
module main

fn main() {
	for i := 0; i < 10; i++ {
		C.printf(c'hello world\n')
	}
	return
}

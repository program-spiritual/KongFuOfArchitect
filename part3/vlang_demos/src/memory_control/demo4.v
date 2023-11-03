struct MyStruct {
mut:
	n int
}

fn (mut a MyStruct) f(b &MyStruct) int {
	a.n += b.n
	x := a.n * b.n
	return x
}

fn main() {
	mut q := MyStruct{
		n: 7
	}
	w := MyStruct{
		n: 13
	}
	x := q.f(&w)
	println('q: ${q} \n x: ${x}')
}

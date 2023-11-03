struct MyStruct {
	n int
}

struct RefStruct {
	r &MyStruct
}

fn f() (RefStruct, &MyStruct) {
	a := MyStruct{
		n: 1
	}
	b := MyStruct{
		n: 2
	}
	c := MyStruct{
		n: 3
	}
	e := RefStruct{
		r: &b
	}
	x := a.n + c.n
	println('x: ${x}')
	return e, &c
}

fn main() {
	q, w := f()
	println('q: ${q.r.n}, w: ${w.n}')
}

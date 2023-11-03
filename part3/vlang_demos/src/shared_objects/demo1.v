struct St {
mut:
	x int
}

fn (shared b St) g() {
	lock b {
	}
}

fn main() {
	shared a := St{
		x: 10
	}
	spawn a.g()
	rlock a {
		// read a.x
		println(a.x)
	}
}

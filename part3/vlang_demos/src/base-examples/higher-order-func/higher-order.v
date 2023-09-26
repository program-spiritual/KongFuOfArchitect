module main

fn sqr(n int) int {
	return n * n
}

fn cube(n int) int {
	return n * n * n
}

fn run(value int, op fn (int) int) int {
	return op(value)
}

fn main() {
	println(sqr(2))
	println(run(5, sqr))
	double_fn := fn (n int) int {
		return 2 * n
	}
	println(run(5, double_fn))
	fns := [sqr, cube]
	println(fns[0](10))
	fns_map := {
		'sqr':  sqr
		'cube': cube
	}
	println(fns_map['cube'](2))
}

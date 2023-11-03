module main

import os

fn main() {
	println('Hello World!')
	println(os.args)
	println(add(12, 22))
	println(sub(12, 12))
}

fn add(x int, y int) int {
	return x + y
}

fn sub(x int, y int) int {
	return x - y
}

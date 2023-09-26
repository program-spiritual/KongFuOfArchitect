module main

import os { input, user_os }

fn main() {
	name := input('enter your name')
	println('hello,${name}')
	current_os := user_os()
	println('current os is ${current_os}')
}

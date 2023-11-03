module main

import mod2
import os

fn main() {
	vmodules := os.vmodules_dir()
	println(vmodules)
	// res := mod1.vadd(1, 2)
	// println(res)
	// assert res == 1003
	a := [1, 2, 3, 4]
	mut vals := []mod2.Vtype{}
	for v in a {
		vals << mod2.new_vtype(v)
	}
	mod2.call_with_array_param(vals)
}

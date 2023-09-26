module main

mut m := {
	'a': 1
	'b': 2
	'c': 3
	'd': 4
	'e': 5
	'f': 6
}
m['one'] = 1
m['two'] = 2
m['three'] = 3
m['four'] = 4
m['five'] = 5
m['six'] = 6
println(m)
println('bad_key' in m)
println(m.keys())
m.delete('six')
println(m)
numbers2 := {
	'one': 1
	'two': 2
}
println(numbers2)

// sm := {
// 	'abc': 'xyz'
// }
// val := sm['bad_key']
// println(val)
int_map := {
	1: 1234
	2: 5678
}
s := int_map[3]
println(s)
mm := {
	'abc': 'def'
}
// val2 := mm['bad_key'] or { panic('key not found') }
// println(val2)
if v := mm['abc'] {
	println(v)
}
// arr := [1, 2, 3]
// large_index := 999
// val := arr[large_index] or { panic('index out of range') }
// println(val)

mut nested_map := {
	'abc': {
		'one': 1
		'two': 2
	}
	'def': {
		'three': 3
		'four':  4
	}
}
println(nested_map)

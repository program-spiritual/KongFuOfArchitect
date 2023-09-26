module main

name := 'Bob'
bobby := name + ' is a good boy'
println(bobby)
mut s := 'hello'
s += ' world'
println(s)

// can not concatenate an integer to string
// println(123 + 'abc')
age := 11
println('age = ' + age.str())
// or use string interpolation (preferred):
println('age = ${age}')

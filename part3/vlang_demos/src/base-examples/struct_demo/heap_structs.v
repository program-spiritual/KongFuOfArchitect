struct Point {
	x int
	y int
}

struct Foo {
mut:
	x int
}

// To allocate a struct on the heap and get a reference to it, use the & prefix:
p := &Point{1, 2}
println(p.x) // 1
println(p.y) // 2

fa := Foo{1}
mut a := fa
a.x = 2
assert fa.x == 1
assert a.x == 2

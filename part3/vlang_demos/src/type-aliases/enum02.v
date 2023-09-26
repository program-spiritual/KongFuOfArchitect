enum Color {
	@none
	red
	green
	blue
}

enum Grocery {
	@none
	apple
	banana
	orange = 5
}

// Enums can have methods, just like structs.
enum Circle {
	@none
	one
	two = 2
	three
}

fn (c Circle) next() Circle {
	match c {
		.@none {
			return .@none
		}
		.one {
			return .two
		}
		.two {
			return .three
		}
		.three {
			return .one
		}
	}
}

mut color := Color.@none
println(color)
color = Color.green
println(color)

// integer my be assigned to enum field

g1 := int(Grocery.@none)
g2 := int(Grocery.apple)
g3 := int(Grocery.orange)
println(g1)
println(g2)
println(g3)

println('Grocery Ids: ${g1}, ${g2}, ${g3}')

mut c := Circle.one
println(c)
c = c.next()
println(c)

// for
for i in 1 .. 10 {
	println(c)
	c = c.next()
}

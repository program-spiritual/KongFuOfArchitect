type NewType = int

enum Color as u8 {
	red
	green
	blue
}

mut color := Color.red
// V knows that `color` is a `Color`. No need to use `color = Color.green` here.
color = .green
println(color)
match color {
	.red {
		println(' the color was red')
	}
	.green {
		println(' the color was green')
	}
	.blue {
		println(' the color was blue')
	}
}

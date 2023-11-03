struct Color {
	r int
	g int
	b int
}

fn rgb(c Color) int {
	return c.r * 256 * 256 + c.g * 256 + c.b
}

fn rgb2(r int, g int, b int) Color {
	return Color{
		r: r
		g: g
		b: b
	}
}

const (
	numbers = [1, 2, 3]
	red     = Color{
		r: 255
		g: 0
		b: 0
	}
	blue = rgb2(0, 0, 255)
)

const (
	pi    = 3.14
	e     = 2.71
	pi2   = pi * pi
	world = '世界'
)

println(numbers)
println(red)
println(blue)
println(pi)
println(e)
println(pi2)
println(world)

struct Color {
	r int
	g int
	b int
}

pub fn (c Color) str() string {
	return '${c.r}, ${c.g}, ${c.b}'
}

red := Color{
	r: 255
	g: 0
	b: 0
}
println(red)

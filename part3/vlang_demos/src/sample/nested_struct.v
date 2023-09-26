module sample

pub struct Size {
pub mut:
	width  int
	height int
}

pub fn (s &Size) area() int {
	return s.width * s.height
}

pub struct Button {
	Size
	title string
}

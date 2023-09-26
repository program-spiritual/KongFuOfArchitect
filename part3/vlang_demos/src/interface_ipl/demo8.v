struct Moon {}

struct Mars {}

struct Venus {}

type World = Mars | Moon | Venus

fn (m Mars) dust_storm() bool {
	return true
}

fn main() {
	mut w := World(Moon{})
	assert w is Moon
	w = Mars{}
	// use as to access the Mars instance
	mars := w as Mars
	if mars.dust_storm() {
		println('bad weather')
	}
}

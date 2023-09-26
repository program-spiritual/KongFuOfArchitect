module main

fn main() {
	println(i32(1))
	println(i64(1))
	println(u8(1))
	println(u16(1))
	println(u32(1))
	println(u64(1))
	println(f32(1))
	println(f64(1))
	u := u16(12)
	v := 13 + u // v is of type `u16` - no promotion
	x := f32(45.6)
	y := x + 3.14 // x is of type `f32` - no promotion
	a := 75 // a is of type `int` - default for int literal
	b := 14.7 // b is of type `f64` - default for float literal
	c := u + a // c is of type `int` - automatic promotion of `u`'s value
	d := b + x // d is of type `f64` - automatic promotion of `x`'s value
	println(c)
	println(d)
	println(v)
	println(x)
	println(y)
}

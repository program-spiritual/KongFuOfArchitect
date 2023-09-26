module main

struct Rgba32_component {
	r u8
	g u8
	b u8
	a u8
	e u8
}

union Rgba32 {
	Rgba32_component
	value u32
}

clr1 := Rgba32{
	value: 0x008811FF
}

clr2 := Rgba32{
	Rgba32_component: Rgba32_component{
		a: 128
	}
}
sz := sizeof(Rgba32)

unsafe {
	println(clr1)
	println(clr2)
	println('Size: ${sz}B,clr1.b ${clr1.b},clr1.value ${clr1.value},clr2.b ${clr2.b}')
}

fn calc() {
	a := 100
	b := 20
	mut c := 0
	asm amd64 {
		mov eax, a
		add eax, b
		mov c, eax
		; =r (c) // output
		; r (a) // input
		  r (b)
	}
	println('a: ${a}') // 100
	println('b: ${b}') // 20
	println('c: ${c}') // 120
}

fn main() {
	calc()
}

fn new_counter() fn () int {
	mut i := 0
	return fn [mut i] () int {
		i++
		return i
	}
}

fn f(a1 int, a2 int, a3 int) {
	dump(a1 + a2 + a3)
}

c := new_counter()
println(c()) // 1
println(c()) // 2
println(c()) // 3

mut i := 0
mut ref := &i
print_counter := fn [ref] () {
	println(*ref)
}

print_counter() // 0
i = 10
print_counter() // 10

f(dump(100), dump(200), dump(300))

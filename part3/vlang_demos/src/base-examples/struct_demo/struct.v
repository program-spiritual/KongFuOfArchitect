struct Foo {
mut:
	x int
}

struct Foo2 {
	n   int    // n is 0 by default
	s   string // s is '' by default
	a   []int  // a is `[]int{}` by default
	pos int = -1 // custom default value
}

[params]
struct ButtonConfig {
	text        string
	is_disabled bool
	width       int = 70
	height      int = 20
}

struct Button {
	text   string
	width  int
	height int
}

fn new_btn(c ButtonConfig) &Button {
	return &Button{
		text: c.text
		width: c.width
		height: c.height
	}
}

struct IUser {
	name          string
	age           int
	is_registered bool
}

fn register(u IUser) IUser {
	return IUser{
		...u
		is_registered: true
	}
}

fa := Foo{1}
mut a := fa
a.x = 2
assert fa.x == 1
assert a.x == 2
mut fc := Foo{1}
mut c := &fc
c.x = 2
assert fc.x == 2
assert c.x == 2
println(fc) // Foo{ x: 2 }
println(c) // &Foo{ x: 2 } // Note `&` prefixed.

mut user := IUser{
	name: 'abc'
	age: 22
	is_registered: false
}

user = register(user)
println(user) // IUser{ name: 'abc', age: 22, is_registered: true }

button := new_btn(text: 'hello', width: 100, is_disabled: true)
assert button.height == 20
println(button) // Button{ text: 'hello', width: 100, height: 20, is_disabled: true }

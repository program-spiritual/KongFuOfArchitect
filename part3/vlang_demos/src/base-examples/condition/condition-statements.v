module main

struct User {
	name string
}

struct Abc {
	val string
}

struct Xyz {
	foo string
}

struct MyStruct {
	x int
}

struct MyStruct2 {
	y string
}

type MySumType = MyStruct | MyStruct2

struct Abcd {
	bar MySumType
}

type Alphabet = Abc | Xyz

arr := [User{'John'}]
u_name := if v := arr[0] {
	v.name
} else {
	'Unnamed'
}
println(u_name)

x := Alphabet(Abc{'test'})
if x is Abc {
	// x is automatically cast to Abc and can be used here
	println(x)
}
if x !is Abc {
	println('not abc')
}

// or using match
match x {
	Abc {
		// x is automatically cast to Abc and can be used here
		println('x is automatically cast to Abc and can be used here')
		println(x)
	}
	Xyz {
		// x is automatically cast to Xyz and can be used here
		println('x is automatically cast to Xyz and can be used here')
		println(x)
	}
}
// This works also with struct fields:

x2 := Abcd{
	bar: MyStruct{123}
}
println(x2)

if x2.bar is MyStruct {
	println(x2.bar)
} else if x2.bar is MyStruct2 {
	mew_var := x2.bar as MyStruct2
	println(mew_var)
}

match x2.bar {
	MyStruct {
		println(x2.bar)
	}
	else {}
}

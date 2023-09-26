struct Dog {
	breed string
}

fn (d Dog) speak() string {
	return 'woof'
}

struct Cat {
	breed string
}

fn (c Cat) speak() string {
	return 'meow'
}

interface Foo {
	write(string) string
}

interface Bar {
mut:
	write(string) string
}

struct MyStruct {
}

fn (s MyStruct) write(a string) string {
	return a
}

fn fn1(s Foo) {
	println(s.write('Foo'))
}

fn fn2(s Bar) {
	println(s.write('Bar'))
}

s1 := MyStruct{}
fn1(s1)

// fn2(MyStruct{})

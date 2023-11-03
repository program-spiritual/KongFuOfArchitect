interface IFoo {
	foo()
}

interface IBar {
	bar()
}

// implement  only IFoo
struct SFoo {
}

fn (sf SFoo) foo() {
}

// implements both IFoo and IBar
struct SFooBar {}

fn (sf SFooBar) foo() {
}

fn (sf SFooBar) bar() {
	dump('this implements both IFoo and IBar')
}

fn main() {
	mut arr := []IFoo{}
	arr << SFoo{}
	arr << SFooBar{}
	for item in arr {
		dump(item)
		if item is IBar {
			item.bar()
		}
	}
}

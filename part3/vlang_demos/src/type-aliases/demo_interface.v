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

//  // unlike Go, but like TypeScript, V's interfaces can define both fields and methods.
interface Speakable {
	breed string
	speak() string
}

dog := Dog{'Leonberger'}
cat := Cat{'Persian'}

mut arr := []Speakable{}

arr << dog
arr << cat

for item in arr {
	println('a ${item.breed} says ${item.speak()}')
}

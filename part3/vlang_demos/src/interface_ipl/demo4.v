interface Adoptable {
}

fn (a Adoptable) adopt() string {
	return 'adopted'
}

fn (a Adoptable) speak() string {
	return 'adopt me'
}

struct Cat {
}

fn (c Cat) speak() string {
	return 'meow'
}

struct Dog {
}

fn main() {
	cat := Cat{}
	assert dump(cat.speak()) == 'meow'
	a := Adoptable(cat)
	// assert dump(a.speak()) == 'meow'
	assert dump(a.speak()) == 'adopt me' // call Adoptable.speak
	if a is Cat {
		assert dump(a.speak()) == 'meow'
	}
	b := Adoptable(Dog{})
	// assert dump(b.speak()) == 'adopted'
	assert dump(b.speak()) == 'adopt me'
	if b is Dog {
		dump(b.speak()) // error: unknown method or field: `Dog.speak`
	}
}

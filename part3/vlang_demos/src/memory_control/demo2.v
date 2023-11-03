import strings

fn draw_text(s string, x int, y int) {
}

fn draw_scene() {
	draw_text('hello world', 10, 10)
	name1 := 'abc'
	name2 := 'def ghi'
	draw_text('hello ${name1}', 10, 10)
	draw_text('hello ${name2}', 100, 10)
	draw_text(strings.repeat(`X`, 10000), 10, 50)
}

struct User {
	name string
}

fn test() []int {
	number := 7 // stack variable
	user := User{
		name: 'abc'
	} // struct allocated on stack
	numbers := int{1, 2, 3, 4, 5} // array allocated on heap, will be freed as the function exits
	println(number)
	println(user)
	println(numbers)
	numbers2 := [4, 5, 6] // array that's being returned, won't be freed here
	return numbers2
}

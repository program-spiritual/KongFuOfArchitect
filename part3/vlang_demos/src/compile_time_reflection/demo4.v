fn build() string {
	name := 'John'
	age := 30
	numbers := [1, 2, 3]
	return $tmpl('1.txt')
}

fn main() {
	println(build())
}

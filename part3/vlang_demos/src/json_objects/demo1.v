import json

struct Foo {
	x int
}

struct User {
	// Adding a [required] attribute will make decoding fail, if that
	// field is not present in the input.
	// If a field is not [required], but is missing, it will be assumed
	// to have its default value, like 0 for numbers, or '' for strings,
	// and decoding will not fail.
	name string [required]
	age  int
	// use skip to ignore a field
	foo Foo [skip]
	//   if the field name is different in JSON it can be specified
	last_name string [json: lastName]
}

data := '{"name": "John", "age": 30, "foo": {"x": 10}, "lastName": "Doe"}'
user := json.decode(User, data) or {
	eprintln('failed to decode user :${err}')
	return
}
println(user.name)
println(user.last_name)
println(user.age)
println(user.foo.x)

// you can also decode JSON array

sfoos := '[{"x":123},{"x":456}]'

foos := json.decode([]Foo, sfoos)!
for item in foos {
	println(item)
	println(item.x)
}

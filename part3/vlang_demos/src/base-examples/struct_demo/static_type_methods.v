struct User {
mut:
	name string
}

fn User.new() User {
	return User{}
}

user := User.new()
println(user) // User{}

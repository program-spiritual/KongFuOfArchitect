struct User {
	id   int
	name string
}

struct Repo {
	users []User
}

fn (r Repo) find_user_by_id(id int) !User {
	for user in r.users {
		if user.id == id {
			//  v automatically wraps this into a result or option type
			return user
		}
	}
	return error('User ${id} not found')
}

//  A version of function using an option
fn (r Repo) find_user_by_id_opt(id int) ?User {
	for user in r.users {
		if user.id == id {
			return user
		}
	}
	return none
}

fn main() {
	repo := Repo{
		users: [
			User{1, 'John'},
			User{2, 'Jane'},
			User{3, 'Bob'},
		]
	}
	user := repo.find_user_by_id(10) or {
		println(err)
		return
	}
	println(user.id)
	println(user.name)
	user2 := repo.find_user_by_id_opt(10) or { return }
}

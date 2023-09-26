module methods

pub struct User {
	age int
}

pub fn (u User) can_register() bool {
	return u.age > 16
}

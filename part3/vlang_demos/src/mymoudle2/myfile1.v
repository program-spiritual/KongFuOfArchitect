module mymoudle2

// say_hi To export a function we have to use `pub`
pub fn say_hi() {
	println('hello from mymodule!')
}

fn init() {
	// The init function cannot be public - it will be called automatically.
	//  This feature is particularly useful for initializing a C library.
	// your setup code here ...
	println('this is a init function!')
}

module struct_demo

[noinit]
struct Information {
pub:
	name string
	age  int
	data string
}

pub fn new_information(data string) !Information {
	if data.len == 0 || data.len > 100 {
		return error('data must be between 1 and 100 characters')
	}
	return Information{
		data: data
	}
}

pub fn new_info(name string, age int) Information {}

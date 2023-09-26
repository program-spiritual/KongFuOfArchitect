$if linux {
	$compile_error('Linux is not supported')
} $else $if windows {
	$compile_error('Windows is not supported')
}

fn main() {
}

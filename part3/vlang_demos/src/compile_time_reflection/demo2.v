fn main() {
	$if ios || android {
		println('running on ios or android')
	}
	$if linux && x64 {
		println('running on linux and x64')
	}
	os := $if windows { 'Windows' } $else { 'UNIX' }
	println('os is ' + os)
	$if tinyc {
		println('compiling on tinyc')
	} $else $if clang {
		println('compiling on clang')
	} $else $if gcc {
		println('compiling on gcc')
	} $else {
		println('compiling on unknown compiler')
	}
	$if test {
		println('testing')
	}
	$if debug {
		println('debugging')
	}
	$if prod {
		println('production')
	}
	$if option ? {
		println('custom option')
	}
}

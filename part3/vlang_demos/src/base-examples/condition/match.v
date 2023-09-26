module main

enum Token {
	plus
	minus
	div
	mult
}

struct Parser {
	token Token
}

enum Color {
	red
	blue
	green
}

fn is_red_or_blue(c Color) bool {
	return match c {
		.red, .blue {
			true
		}
		.green {
			false
		}
	}
}

const start = 1

const end = 10

os := 'windows'
print('V is running on \n')
match os {
	'darwin' { println('macos') }
	'windows' { println('windows') }
	else { println(os) }
}
number := 2
s := match number {
	1 { 'one' }
	2 { 'two' }
	else { 'many' }
}
println(s)

match true {
	2 > 4 { println('if') }
	3 == 4 { println('else if') }
	2 == 2 { println('else if2') }
	else { println('else') }
}
match false {
	2 > 4 { println('if') }
	3 == 4 { println('else if') }
	2 == 2 { println('else if2') }
	else { println('else') }
}

c := `v`
typ := match c {
	`0`...`9` {
		'digit'
	}
	`a`...`z` {
		'lowercase'
	}
	`A`...`Z` {
		'uppercase'
	}
	else {
		'other'
	}
}
println(typ)

cc := 2

num := match cc {
	start...end {
		1000
	}
	else {
		0
	}
}
println(num)

// in operator

numbers := [1, 2, 3, 4, 5, 6]
println(1 in numbers)
println(4 !in numbers)

map_data1 := {
	'one': 1
	'two': 2
}
println('one' in map_data1)
println('three' in map_data1)
parser := Parser{}
if parser.token in [.plus, .minus, .div, .mult] {
	println('token true')
} else {
	println('false')
}

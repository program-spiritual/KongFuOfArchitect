module main

enum Token {
	plus
	minus
	div
	multiply
}

struct Parser {
	token Token
}

parser := Parser{}

if parser.token in [.plus, .minus, .div, .multiply] {
	println('token:${parser.token}')
}

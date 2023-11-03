module main

const rocket = '🚀'

fn main() {
	name := 'Bob'
	assert name.len == 3
	// will print 3
	assert name[0] == u8(66)
	// indexing gives a byte, u8(66) == `B`
	assert name[1..3] == 'ob'
	// slicing gives a string 'ob'

	// escape codes
	windows_newline := '\r\n' // escape special characters like in C
	assert windows_newline.len == 2

	// arbitrary bytes can be directly specified using `\x##` notation where `#` is
	// a hex digit aardvark_str := '\x61ardvark' assert aardvark_str == 'aardvark'
	assert '\xc0'[0] == u8(0xc0)

	// or using octal escape `\###` notation where `#` is an octal digit
	aardvark_str2 := '\141ardvark'
	assert aardvark_str2 == 'aardvark'

	// Unicode can be specified directly as `\u####` where # is a hex digit
	// and will be converted internally to its UTF-8 representation
	star_str := '\u2605' // ★
	assert star_str == '★'
	println(star_str)
	assert star_str == '\xe2\x98\x85'
	// UTF-8 can be specified this way too.
	s := 'hello 🌎' // emoji takes 4 bytes
	assert s.len == 10

	arr := s.bytes() // convert `string` to `[]u8`
	assert arr.len == 10

	s2 := arr.bytestr() // convert `[]byte` to `string`
	assert s2 == s
	s3 := '42'
	n := s3.int() // 42
	println(n)
	// all int literals are supported
	assert '0xc3'.int() == 195
	assert '0o10'.int() == 8
	assert '0b1111_0000_1010'.int() == 3850
	assert '-0b1111_0000_1010'.int() == -3850
	one_user := 'Bob'
	println('Hello, ${one_user}!') // Hello, Bob!
	age := 20
	println('age = ${age}')
	country := 'Netherlands'
	println(country[0]) // Output: 78
	println(country[0].ascii_str()) // Output: N
	sss := r'hello\nworld' // the `\n` will be preserved as two characters
	println(sss) // "hello\nworld"
	println('can register = ${age > 13}')
	println(rocket)
	assert rocket.str() == '🚀'
	println(rocket.bytes())
	assert rocket.bytes() == [u8(0xf0), 0x9f, 0x9a, 0x80]
	assert `\x61` == `a`
	assert `\141` == `a`
	assert `\u0061` == `a`

	// multibyte literals work too
	assert `\u2605` == `★`
	assert `\u2605`.bytes() == [u8(0xe2), 0x98, 0x85]
	assert `\xe2\x98\x85`.bytes() == [u8(0xe2), 0x98, 0x85]
	assert `\342\230\205`.bytes() == [u8(0xe2), 0x98, 0x85]
	rocket_string := '🚀'
	assert rocket_string[0] != `🚀`
	assert 'aloha!'[0] == `a`
	hello := 'Hello World 👋'
	hello_runes := hello.runes() // [`H`, `e`, `l`, `l`, `o`, ` `, `W`, `o`, `r`, `l`, `d`, ` `, `👋`]
	println(hello_runes)
	assert hello_runes.string() == hello
}

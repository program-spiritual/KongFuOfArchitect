module main

rocket := '🚀'
println(rocket)

assert rocket.str() == '🚀'
assert rocket.bytes() == [u8(0xf0), (0x9f), (0x9a), (0x80)]
assert `\x61` == `a`
// 16进制
assert `\141` == `a`
// 8进制
assert `\u0061` == `a`
// unicode

// multibyte literals work too
assert `\u2605` == `★`
assert `\u2605`.bytes() == [u8(0xe2), 0x98, 0x85]
assert `\xe2\x98\x85`.bytes() == [u8(0xe2), 0x98, 0x85]
assert `\342\230\205`.bytes() == [u8(0xe2), 0x98, 0x85]
rocket_string := '🚀'
assert rocket_string[0] != `🚀`
assert 'aloha!'[0] == `a`
hello := 'Hello World 👋'
hello_runes := hello.runes()
println(hello_runes)
assert hello_runes.string() == hello

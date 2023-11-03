module main

m := {
	'one': 1
	'two': 2
}

for key, value in m {
	println('key:${key} value:${value}')
}

for key, _ in m {
	println('key:${key}')
}
for _, val in m {
	println('val:${val}')
}

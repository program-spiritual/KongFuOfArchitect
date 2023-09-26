module main

numbers := [1, 2, 3, 4, 5]
for num in numbers {
	println(num)
}
names := ['Sam', 'Peter', 'John']
for i, name in names {
	println('${i}: ${name}')
}
mut mut_numbers := [1, 2, 3, 4, 5]
for mut num in mut_numbers {
	num++
}
println(mut_numbers)

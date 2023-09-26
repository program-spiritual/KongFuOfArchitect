module main

struct User {
	age  int
	name string
}

mut a := [][]int{len: 2, init: []int{len: 3}}
a[0][1] = 2
println(a) // [[0, 2, 0], [0, 0, 0]]

mut nums := [1, 2, 3, 4, 5, 6]

// filter can accept anonymous function
even_fn := nums.filter(fn (i int) bool {
	return i % 2 == 0
})

println(even_fn)
words := ['hello', 'world']
upper := words.map(it.to_upper())
println(upper) // ['HELLO', 'WORLD']
// map can also accept anonymous functions
upper_fn := words.map(fn (w string) string {
	return w.to_upper()
})
println(upper_fn) // ['HELLO', 'WORLD']

println(nums.any(it == 2)) // true
println(nums.all(it == 2)) // false
nums.sort(a > b)
println(nums)

mut users := [User{
	age: 10
	name: 'Bob'
}, User{
	age: 20
	name: 'Zarkon'
}, User{
	age: 30
	name: 'Alice'
}]

users.sort(a.age < b.age)
println(users)
users.sort(a.name > b.name)
println(users)

mut numbers := [0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
numbers.sort(a > b)
println(numbers)

println(numbers[1..3])
println(numbers[..4])
println(numbers[1..])

array_1 := [3, 5, 7, 9, 11]
mut array_2 := [0, 1, 2]
array_2 << array_1
println(array_2)

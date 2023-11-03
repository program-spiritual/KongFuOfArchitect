module main

mut nums := [1, 2, 3, 4, 5]
println(nums)
println(nums[0])
// edit
nums[1] = 5
println(nums)
nums << 6
println(nums)
// append array
nums << [7, 8, 9]
println(nums)
mut names := ['John', 'Jane', 'Jack']
names << 'Petter'
names << 'Sam'
println(names)
println('Alex' in names)

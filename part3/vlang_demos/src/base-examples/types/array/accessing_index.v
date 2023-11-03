module main

// 通过存取索引变量的方式来初始化数组
count := []int{len: 4, init: index}
println(count)
assert count == [0, 1, 2, 3]
//  通过存取索引变量的方式来初始化数组 -- 计算平方
mut square := []int{len: 6, init: index * index}
println(square)

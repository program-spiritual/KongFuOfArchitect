module main

/**
* ${varname:[flags][width][.precision][type]}
*/
x := 123.4567
println('${x:.2}') // 四舍五入2位数
println('${x:10}') // 使用左侧空格右对齐
println('[${int(x):-10}]') // 空格在右侧的左对齐
println('[${int(x):010}]') // pad with zeros on the left => [0000000123]
println('[${int(x):b}]') // output as binary => [1111011]
println('[${int(x):o}]') // output as octal => [173]
println('[${int(x):X}]') // output as uppercase hex => [7B]

println('[${10.0000:.2}]') // remove insignificant 0s at the end => [10]
println('[${10.0000:.2f}]') // do show the 0s at the end, even though they do not change the number => [10.00]

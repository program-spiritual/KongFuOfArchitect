const numbers = [1, 2, 3]
numbers[10] = 11
console.log(numbers)


// 当你为数组设置超过数组长度的值的时候， JavaScript 会创建名为 "empty slots" 的东西。它们的值实际上是 undefined。你会看到以下场景：
//
//[1, 2, 3, 7 x empty, 11]
//
//这取决于你的运行环境（每个浏览器，以及 node 环境，都有可能不同）

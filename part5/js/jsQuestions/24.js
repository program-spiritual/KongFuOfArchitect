const obj = { 1: 'a', 2: 'b', 3: 'c' }
const set = new Set([1, 2, 3, 4, 5])

obj.hasOwnProperty('1')
obj.hasOwnProperty(1)
set.has('1')
set.has(1)

// 所有对象的键（不包括 Symbol）在底层都是字符串，即使你自己没有将其作为字符串输入。这就是为什么 obj.hasOwnProperty('1') 也返回 true。
//
//对于集合，它不是这样工作的。在我们的集合中没有 '1'：set.has('1') 返回 false。它有数字类型为 1，set.has(1) 返回 true。

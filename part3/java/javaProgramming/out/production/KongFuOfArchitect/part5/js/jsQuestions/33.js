const person = { name: 'Lydia' }

function sayHi(age) {
  console.log(`${this.name} is ${age}`)
}

sayHi.call(person, 21)
sayHi.bind(person, 21)

// 使用这两种方法，我们都可以传递我们希望 this 关键字引用的对象。但是，.call 是立即执行的。
//
//.bind 返回函数的副本，但带有绑定上下文！它不是立即执行的。

let target = {};
let proxy = new Proxy(target, {}); // 空的 handler 对象

proxy.test = 5; // 写入 proxy 对象 (1)
console.log(target.test); // 5，test 属性出现在了 target 中！

console.log(proxy.test); // 5，我们也可以从 proxy 对象读取它 (2)

for(let key in proxy) console.log(key); // test，迭代也正常工作 (3)

let numbers = [0, 1, 2];

numbers = new Proxy(numbers, {
  get(target, prop) {
    if (prop in target) {
      return target[prop];
    } else {
      return 0; // 默认值
    }
  }
});
console.log(numbers[123])
let dictionary = {
  'Hello': 'Hola',
  'Bye': 'Adiós'
};
dictionary = new Proxy(dictionary, {
  get(target, phrase) { // 拦截读取属性操作
    if (phrase in target) { //如果词典中有该短语
      return target[phrase]; // 返回其翻译
    } else {
      // 否则返回未翻译的短语
      return phrase;
    }
  }
});
console.log(dictionary['Welcome to Proxy'])
let numbers = []
numbers = new Proxy(numbers,{
  set(target, p, value, receiver) {
    if (typeof value == 'number') {
      target[p] = value;
      return true;
    } else {
      return false;
    }
  }
})
numbers.push(1); // 添加成功
numbers.push(2); // 添加成功
console.log("Length is: " + numbers.length); // 2

numbers.push("test"); // TypeError（proxy 的 'set' 返回 false）

let user = {
  name: "John",
  age: 30,
  _password: "***"
};
user = new Proxy(user,{
  ownKeys(target) {
    return Object.keys(target).filter(key=>!key.startsWith('_'))
  }
})
for (const userKey in user) {
  console.log(userKey)
}
console.log(Object.values(user));

let user = { };

user = new Proxy(user, {
  ownKeys(target) { // 一旦要获取属性列表就会被调用
    return ['a', 'b', 'c'];
  },

  getOwnPropertyDescriptor(target, prop) { // 被每个属性调用
    return {
      enumerable: true,
      configurable: true
      /* ...其他标志，可能是 "value:..." */
    };
  }

});

console.log(Object.keys(user));
let user = {
  name: "John",
  c(){ return `${this.name} function returned string`},
  _password: "***"
};
user = new Proxy(user,{
  get(target, p, receiver) {
    if (p.startsWith('_')) {
      throw new Error('access denied')
    }
    let value = target[p];
    return (typeof value === 'function') ? value.bind(target) : value; // (*)
  },
  set(target, p, value, receiver) {
    if (p.startsWith('_')) {
      throw new Error('access denied')
    } else {
      target[p] = value
      return true
    }
  },
  deleteProperty(target, p) {
    if (p.startsWith('_')) {
      throw new Error('access denied')
    } else {
      target[p] = value
      return true
    }
  },
  ownKeys(target) {
    return Object.keys(target).filter(key=>!key.startsWith('_'));
  }
})

console.log(user._password);
console.log(user.c());
user._password = 'test';
delete user._password;
for (const userKey in user) {
  console.log(userKey)
}
let range = {
  start: 1,
  end: 10
};
range = new Proxy(range,{
  has(target, p) {
    return p >= range.start && p <= range.end;
  }
})
console.log(5 in range);
console.log(22 in range);

function delay(f, ms) {
  // 返回一个包装器（wrapper），该包装器将在时间到了的时候将调用转发给函数 f
  return function() { // (*)
    setTimeout(() => f.apply(this, arguments), ms);
  };
}

function sayHi(user) {
  console.log(`Hello, ${user}!`);
}

// 在进行这个包装后，sayHi 函数会被延迟 3 秒后被调用
sayHi = delay(sayHi, 3000);

sayHi("John"); // Hello, John! (after 3 seconds)
function delay(f, ms) {
  return new Proxy(f, {
    // target 是目标对象（在 JavaScript 中，函数就是一个对象），
    // thisArg 是 this 的值。
    // args 是参数列表。
    apply(target, thisArg, argArray) {
      console.log('thisArg:',thisArg)
      setTimeout(() =>target.apply(thisArg,argArray), ms);
    }
  });
}
function sayHi(user) {
  console.log(`this, ${this}!`);
  console.log(`Hello, ${user}!`);
}
sayHi = delay(sayHi, 3000);

console.log(sayHi.length);
sayHi("John"); // Hello, John!（3 秒后）

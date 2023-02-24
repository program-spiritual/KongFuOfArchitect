let user = {};

Reflect.set(user, 'name', 'John');

console.log(user.name); // John

let user = {}
user = new Proxy(user,{
  get(target, p, receiver) {
    console.log("-> getProps", p);
    console.log("-> receiver", receiver);
    return Reflect.get(target, p, receiver);
  },
  set(target, p, value, receiver) {
    console.log("-> setProps", p);
    return Reflect.set(target, p, value, receiver);
  }
})
let name = user.name; // 显示 "GET name"
user.name = "Pete"; // 显示 "SET name=Pete"

let user = {
  _name: "Guest",
  get name() {
    return this._name;
  }
};
let userProxy = new Proxy(user, {
  get(target, prop, receiver) {
    return Reflect.get(target,prop,receiver)
  }
});
// console.log(userProxy.name);
let admin = {
  __proto__: userProxy,
  _name: "Admin"
};

console.log(admin.name);

let map = new Map();

let proxy = new Proxy(map, {});

proxy.set('test', 1); // TypeError: Method Map.prototype.set called on incompatible receiver [object Object]

resolve prev question:
  
  let map = new Map();
let proxy = new Proxy(map,{
  // Comment: This method will be called when a property of object is looked up
  get(target, p, receiver) {
    console.log("-> p", p); // Comment: Logs the property that is being accessed
    let value = Reflect.get(...arguments);
    console.log("-> value", value); // Comment: Logs the value returned from the get function
    return typeof value == 'function' ? value.bind(target) : value; // Comment: If the returned value is a function, it binds it to the target object, else returns the value
  }
});

proxy.set('test', 1);
console.log(proxy.get('test')); // 1（工作了！）


class User {
  #name = "Guest";
  
  getName() {
    return this.#name;
  }
}

let user = new User();

// user = new Proxy(user, {});

// console.log(user.getName()); // TypeError: Cannot read private member #name from an object whose class did not declare it

user = new Proxy(user, {
  get(target, prop, receiver) {
    let value = Reflect.get(...arguments);
    console.log("-> value", value);
    return typeof value == 'function' ? value.bind(target) : value;
  }
});

console.log(user.getName()); // Guest


let allUsers = new Set();

class User {
  constructor(name) {
    this.name = name;
    allUsers.add(this);
  }
}

let user = new User("John");

console.log(allUsers.has(user)); // true

user = new Proxy(user, {});

console.log(allUsers.has(user)); // false
let object = {
  data: "Valuable data"
};

let {proxy, revoke} = Proxy.revocable(object, {

})
console.log(proxy.data);
revoke();
console.log(proxy.data);

let revokes = new WeakMap();

let object = {
  data: "Valuable data"
};

let {proxy, revoke} = Proxy.revocable(object, {});

revokes.set(proxy, revoke);

// ...我们代码中的其他位置...
revoke = revokes.get(proxy);
revoke();

console.log(proxy.data); // Error（revoked）


/**
 * Scope.js  ES6  Version
 * 测试JavaScript的作用域
 */
const a = 5;
const b = 5;
console.log("1: a=%d b=%d", a, b);

if (a > 0) {
    a = 4;
    console.log("2: a=%d b=%d", a, b);
    const b = 3; //看似声明了一个新变量，其实还是引用的外部变量
    console.log("3: a=%d b=%d", a, b);
}
else {
    const b = 4;
    console.log("4: a=%d b=%d", a, b);
}

console.log("5: a=%d b=%d", a, b);

for (const b = 0; b< 2; b++){  //这里是否能声明一个新变量，用于for循环？
    console.log("6-%d: a=%d b=%d",b, a, b);
}

console.log("7: a=%d b=%d", a, b);


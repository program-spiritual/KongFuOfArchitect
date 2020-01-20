
/**
 * clojure.js
 * 测试闭包特性
 * 作者：宫文学
 */
var a = 0;

var fun1 = function(){
    var b = 0;                // 函数内的局部变量

    var inner = function(){   // 内部的一个函数
        a = a+1;
        b = b+1;
        return b;             // 返回内部的成员
    }

    return inner;             // 返回一个函数
}

console.log("outside:  a=%d", a);

var fun2 = fun1();                            // 生成闭包
for (var i = 0; i< 2; i++){
    console.log("fun2: b=%d a=%d",fun2(), a); //通过fun2()来访问b
}

var fun3 = fun1();                            // 生成第二个闭包
for (var i = 0; i< 2; i++){
    console.log("fun3: b=%d a=%d",fun3(), a); // b等于1，重新开始
}
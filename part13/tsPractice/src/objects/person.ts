var person = {
  firstName: "tom",
  lastName: "Hanks",
  sayHello:function() {  }
}
person.sayHello = function() {
  console.log("hello "+person.firstName)
}
person.sayHello()

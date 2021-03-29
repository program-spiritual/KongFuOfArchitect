interface genericIdentityFn {
  <T>(arg: T): T
}

function identity<Type>(arg: Type): Type {
  return arg;
}

let myIdentity: genericIdentityFn = identity

class GenericNumber<T> {
  zeroVal: T;
  add: (x: T, y: T) => T
}

let myGenericNumber = new GenericNumber<number>();
myGenericNumber.zeroVal = 0;
myGenericNumber.add = function (x, y) {
  return x + y;
}

interface LengthWise {
  length: number
}

function loggingIdentity<T extends LengthWise>(arg: T): T {
  console.log(arg.length); // Now we know it has a .length property, so no more error
  return arg;
}

loggingIdentity('1232323');

function getProperty<T,K extends keyof T>(obj:T,key:K) {
  return obj[key];
}

let x = { a: 1, b: 2, c: 3, d: 4 };

getProperty(x, "a");
// getProperty(x, "m");

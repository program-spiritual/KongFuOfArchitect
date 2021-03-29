type Point = {x:number,y:number}

type P = keyof Point

const p:P ='x'
console.log(p);

type Arrayish = {[n:number]:unknown}
type A = keyof Arrayish

const aa:A = 123

type Mapish = {[k:string]:boolean}


type M = keyof Mapish;

const map:M = '123'

type Predicate = (x:unknown) => boolean

function f() {
  return {x:10,y:3}
}


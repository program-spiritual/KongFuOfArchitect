module main
fn foo() (int, int) {
  return 2, 3
}

 fn main(){

   a, b := foo()
   println(a) // 2
   println(b) // 3
   c, _ := foo() // ignore values using `_`
   println(c) // 2
 }

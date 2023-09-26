fn f(c chan int) {
}

ch := chan int{cap: 1}
ch2 := chan f64{cap: 100}

n := 5
// push
ch <- n
ch2 <- 7.3

mut y := f64(0.0)
//  pop create new variable
m := <-ch
//  pop into existing variable
y = <-ch2

println(m)
println(y)

ch.close()
mm := <-ch or { println('channel has been closed') }
println(mm)

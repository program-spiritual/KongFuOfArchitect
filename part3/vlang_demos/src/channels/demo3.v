import time

fn main() {
	ch := chan f64{} // create channel
	ch2 := chan f64{}
	ch3 := chan f64{}
	mut b := 0.0
	c := 1.0
	// ... setup spawn threads that will send on ch/ch2
	spawn fn (the_channel chan f64) {
		time.sleep(5 * time.millisecond)
		the_channel <- 1.0
	}(ch)
	spawn fn (the_channel chan f64) {
		time.sleep(1 * time.millisecond)
		the_channel <- 2.0
	}(ch2)
	spawn fn (the_channel chan f64) {
		_ := <-the_channel
	}(ch3)
	select {
		a := <-ch {
			//  do something with a
			eprintln('> a :${a}')
		}
		b = <-ch2 {
			// do something with predeclared variable `b`
			eprintln('> b: ${b}')
		}
		ch3 <- c {
			// do something if `c` was sent
			time.sleep(5 * time.millisecond)
			eprintln('> c: ${c} was send on channel ch3')
		}
		ch3 <- c {
			// do something if `c` was sent
			time.sleep(5 * time.millisecond)
			eprintln('> c: ${c} was send on channel ch3')
		}
	}
}

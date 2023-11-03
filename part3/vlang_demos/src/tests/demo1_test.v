fn test_assertion_with_extra_message_failure() {
	for i in 0 .. 100 {
		assert i * 2 - 45 < 75 + 10, 'assertion failed for i: ${i}'
	}
}

[assert_continues]
fn abc(ii int) {
	assert ii == 2
}

fn test_abc_with_extra_message() {
	for i in 0 .. 4 {
		abc(i)
	}
}

/*
*.\\demo1.v:9: FAIL: fn main.abc: assert ii == 2
   left value: ii = 0
  right value: 2
.\\demo1.v:9: FAIL: fn main.abc: assert ii == 2
   left value: ii = 1
  right value: 2
.\\demo1.v:9: FAIL: fn main.abc: assert ii == 2
   left value: ii = 3
  right value: 2

  **/

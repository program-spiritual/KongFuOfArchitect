import net.http

fn f(url string) !string {
	resp := http.get(url)!
	return resp.body
}

fn do_something(s string) !string {
	if s == 'foo' {
		return 'foo'
	}
	return error('invalid string')
}

a := do_something('foo') or { 'default' } // a will be 'foo'
b := do_something('bar') or { 'default' } // b will be 'default'
println(a)
println(b)

if resp := http.get('https://baidu.com') {
	println(resp.body) // resp is a http.Response, not an option
} else {
	println(err)
}

type Filter = fn (string) string

fn filter(s string, f Filter) string {
	return f(s)
}

fn uppercase(s string) string {
	return s.to_upper()
}

my_filter := Filter(uppercase)
println(filter('Hello world', my_filter))
println(filter('Hello world', fn (s string) string {
	return s.to_upper()
}))

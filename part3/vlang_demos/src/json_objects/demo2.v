import json

struct User {
	name  string
	score i64
}

mut data := map[string]int{}
user := &User{
	name: 'Pierre'
	score: 1024
}

data['x'] = 42
data['y'] = 360
println(json.encode(data))
println(json.encode(user))

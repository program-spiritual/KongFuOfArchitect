struct Moon {
}

struct Mars {
}

struct Venus {
}

type World = Mars | Moon | Venus

sum := World(Moon{})
assert sum.type_name() == 'Moon'
println(sum)

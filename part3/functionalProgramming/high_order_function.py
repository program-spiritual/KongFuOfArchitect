def twice(function):
    return lambda x: function(function(x))


def f(x):
    return x + 3


g = twice(f)
print(g(7))

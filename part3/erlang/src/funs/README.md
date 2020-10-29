`Fun` 用于在 `Erlang` 中定义匿名函数。
匿名函数的一般语法如下：

```erlang
F = fun (Arg1, Arg2, ... ArgN) ->
   ...
End
```

- `F` -这是分配给匿名函数的变量名。
- `Arg1, Arg2, ... ArgN`  - 这些是传递给匿名函数的参数。

以下示例展示了如何使用匿名函数。

```erlang

-module(funs_hello_world).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  A = fun() -> io:fwrite("Hello") end,
  A().
```

匿名函数被分配给变量A。
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

- 匿名函数被分配给变量A。

匿名函数具有访问匿名函数范围之外的变量的能力。
让我们看一个例子-

```erlang
-module(funs_variable).
-author("Administrator").

%% API
-export([start/0]).
start()->
  B = 6,
  A = fun(X) ->
    io:fwrite("~p~n",[X]),
    io:fwrite("~p~n",[B])
      end,
  A(5).
```
- 高阶函数

高阶函数的另一个最强大的方面之一是，您可以在函数中定义一个函数。
让我们来看一个如何实现此目标的示例。


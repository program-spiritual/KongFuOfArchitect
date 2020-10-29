宏通常用于内联代码替换。
在 `Erlang` 中，宏是通过以下语句定义的。
- `-define(Constant, Replacement).`
- -`define(Func(Var1, Var2,.., Var), Replacement).`

以下是使用第一种语法的宏示例：

```erlang

-module(hello_world).
-author("Administrator").
-define(a,1).
%% API
-export([start/0]).
start() ->
  io:fwrite("~w",[?a]).
```

从上面的程序中，您可以看到使用 `?` 符号展开了宏。

常量将替换为宏中定义的值。

上面程序的输出将是-


```text
1
```

使用函数类的宏的示例如下：

```erlang

-module(macro_function).
-author("Administrator").

%% API
-export([start/0]).
-define(add(X,Y),{X+Y}).
start() ->
  io:fwrite("~w",[?add(1,2)]).
```

以下附加语句可用于宏：

- `undef(Macro)` - 取消宏定义，此后，您将无法调用宏。
- `ifdef(Macro)` - 仅在定义了宏的情况下，才评估以下几行。
- `ifndef(Macro)` - 仅当未定义宏时才评估以下几行。
- `else(Macro)` - 允许在 `ifdef` 或 `ifndef` 语句之后。如果条件为假，则评估 `else` 后面的语句。
- `endif`  - 标记 `ifdef` 或 `ifndef` 语句的结尾。

使用上述语句时，应按照以下程序中所示的正确方式使用它。

```erlang
-ifdef(<FlagName>).

-define(...).
-else.
-define(...).
-endif.

```
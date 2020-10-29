在编译 `Erlang` 模块之前，它会由 `Erlang` 预处理程序自动处理。
预处理器将延展源文件中可能存在的所有宏，并插入任何必要的包含文件。

通常，您无需查看预处理器的输出，但是在特殊情况下（例如，调试错误的宏时），您可能希望保存预处理器的输出。
要查看预处理模块 `some_module.erl` 的结果，请使用 系统` Shell` 命令。

```shell
erlc -P some_module.erl
```

例如，假设我们有以下代码文件-

```erlang

-module(hello_world).
-author("Administrator").
-include("user.hrl").
%% API
-export([]).
start()->
  io:fwrite("~w",[?add(1,2)]).
```

如果我们从命令行执行以下命令:

```shell 
erlc –P hello_world.erl
```
将会生成一个名为 `hello_world.P` 的文件。
如果打开此文件，则会发现以下内容，这些内容是预处理器将编译的内容。

```erlang
-file("hello_world.erl", 1).

-module(hello_world).

-author("Administrator").

-file("user.hrl", 1).

-author("Administrator").

-record(person,{name = "", id}).

-file("hello_world.erl", 4).

-export([start/0]).

start() ->
    io:fwrite("~w", [{1 + 2}]).

```
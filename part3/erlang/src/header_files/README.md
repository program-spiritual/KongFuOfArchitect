头文件就像其他任何编程语言中的包含文件一样。
这对将模块拆分为不同的文件，然后将这些头文件组成单独的程序很有用。
要查看运行中的头文件，让我们看一下我们较早的记录示例之一。

```erlang

-author("Administrator").
-record(person,{name="",id}).
```

现在在我们的主程序文件中，添加以下代码：

```erlang
-module(hello_world). 
-export([start/0]). 
-include("user.hrl"). 

start() -> 
   P = #person{name = "John",id = 1}, 
   io:fwrite("~p~n",[P#person.id]), 
   io:fwrite("~p~n",[P#person.name]).
```

从上面的程序中可以看到，我们实际上只是包括了 `user.hrl` 文件，
该文件会自动在其中插入`–record`代码。
如果执行上述程序，将得到以下输出。

```text
1
"John"
```

您也可以对宏执行相同的操作，可以在头文件中定义宏并在主文件中引用它。
让我们看一个例子-

首先，我们创建一个名为 `user.hrl` 的文件，并添加以下代码-

```erlang
-define(add(X,Y),{X+Y}).
```

然后在主程序中调用：

```erlang
 io:fwrite("~w", [?add(1, 2)]).
```


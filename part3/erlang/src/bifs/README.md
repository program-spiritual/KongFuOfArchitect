 `BIF` 是 `Erlang` 中内置的函数。
他们通常执行无法在 `Erlang` 中编程的任务。
例如，不可能将列表变成元组或找到当前时间和日期。
为了执行这样的操作，我们称为 `BIF` 。
让我们举一个如何使用 `BIF` 的示例-

```erlang
-module(hello_world).
-author("Administrator").

%% API
-export([start/0]).
start()->
  io:fwrite("~p~n",[tuple_to_list({1,2,3})]),
  io:fwrite("~p~n",[time()]).
```


让我们看一下 `Erlang` 中可用的更多 `BIF` 函数。

## 时间

```erlang
 io:fwrite("~p~n",[date()]).
```
## 字节大小

```erlang
 io:fwrite("~p~n",[byte_size(<<1,2,3>>)]).
```

## 元素

```erlang
  io:fwrite("~p~n",[element(1, {a, b, c})]),
  io:fwrite("~p~n",[element(2, {a, b, c})]),
  io:fwrite("~p~n",[element(3, {a, b, c})]).
```

## 浮点数

```erlang
float_demo() ->
  io:fwrite("~p~n", [float(5)]).
```

## 获取字典

```erlang
get_demo() ->
  put(1, "One"),
  put(2, "Two"),
%%  The method returns the process dictionary as a list.
  io:fwrite("~p~n", [get()]).
```

## 存储字典

```erlang
put_demo() ->
%%  This method is used to put a key, value pair in the process dictionary.
  put(1, "One"),
  put(2, "Two"),
  io:fwrite("~p~n", [get()]).
```

## 本地时间

````erlang
localtime_demo()->
  io:fwrite("~p~n",[erlang:localtime()]).
````

## 内存信息

返回一个列表，其中包含有关由 `Erlang` 仿真器动态分配的内存的信息。该列表的每个元素都是一个元组`{Type，Size}`。
第一个元素 `Type` 是描述内存类型的原子。

```erlang
memory_demo()->
  io:fwrite("~p~n",[erlang:memory()]).
```

## 格林尼治时间

此方法返回元组 `{MegaSecs,Secs,MicroSecs}` ，它是从1970年1月1日格林威治标准时间00:00开始经过的时间。

```erlang
now_demo()->
  io:fwrite("~p~n",[erlang:now()]).
```

## 端口 

返回本地节点上所有端口的列表。

```erlang
ports_demo() ->
  io:fwrite("~w~n", [erlang:ports()]).
```

## 进程

返回与本地节点上当前存在的所有进程相对应的进程标识符的列表。

```erlang
processes_demo()->
  io:fwrite("~p~n",[erlang:processes()]).
```

输出：

```text
[<0.0.0>,<0.1.0>,<0.2.0>,<0.3.0>,<0.4.0>,<0.5.0>,<0.6.0>,<0.7.0>,<0.9.0>,
 <0.10.0>,<0.42.0>,<0.44.0>,<0.46.0>,<0.47.0>,<0.49.0>,<0.50.0>,<0.51.0>,
 <0.52.0>,<0.53.0>,<0.54.0>,<0.55.0>,<0.56.0>,<0.57.0>,<0.58.0>,<0.59.0>,
 <0.60.0>,<0.61.0>,<0.62.0>,<0.63.0>,<0.64.0>,<0.65.0>,<0.66.0>,<0.67.0>,
 <0.68.0>,<0.69.0>,<0.71.0>,<0.72.0>]
```

## 世界时间

如果基础操作系统支持，则根据世界标准时间（`UTC`）（也称为`GMT`）以`{{Year, Month, Day}, {Hour, Minute, Second}}`的形式返回当前日期和时间。

```erlang
universaltime_demo()->
  io:fwrite("~p~n ",[erlang:universaltime()]).
```
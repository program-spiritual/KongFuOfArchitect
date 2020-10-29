使用称为二进制的数据结构来存储大量原始数据。
二进制文件以比列表或元组更节省空间的方式存储数据，
并且运行时系统针对二进制文件的有效输入和输出进行了优化。

二进制文件以整数或字符串序列的形式写入和打印，
并以小于和大于双括号的形式括起来。

以下是 `Erlang` 中二进制文件的示例-

```erlang

-module(hello_world).
-author("Administrator").

%% API
-export([start/0]).
start()->
%%  binary
  io:fwrite("~p~n",[<<5,10,20>>]),
  io:fwrite("~p~n",[<<"hello">>]).

```

## 函数

### 列表转二进制

```erlang
list_to_binary_demo()->
  io:fwrite("~p~n",[list_to_binary([1,2,3])]).
```

### 拆分二进制

此方法用于根据指定的索引位置拆分二进制列表。

```erlang
split_binary_demo()->
  io:fwrite("~p~n",[split_binary(<<1,2,3,4,5>>,3)]).
```

### 术语转二进制

```erlang
term_to_binary_demo() ->
  io:fwrite("~p~n", [term_to_binary("hello")]).
```
### 是否是二进制

```erlang
-module(binaries_is_binary).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n",[is_binary(<<1,2,3>>)]).
```

### 提取二进制部分字符串

````erlang

-module(binaries_binary_part).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n",[binary_part(<<1,2,3,4,5>>,{0,2})]).

````

### 转为浮点数

```erlang

-module(binaries_binary_to_float).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n",[binary_to_float(<<"2.2">>)]).
```

### 转为整型数字

```erlang

-module(binaries_binary_to_integer).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n",[binary_to_integer(<<"2">>)]).
```

### 转为列表

```erlang
-module(binaries_binary_to_list).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n",[binary_to_list(<<2,1>>)]).
```

### 转为原子类型

```erlang

-module(binaries_binary_to_atom).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n",[binary_to_atom(<<"Erlang">>, latin1)]).

```
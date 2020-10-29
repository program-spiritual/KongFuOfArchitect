`Guard`是可以用来增加模式匹配功能的结构。
使用`Guard`，我们可以对模式中的变量执行简单的测试和比较。

_`Guard`_ 语句的一般语法如下：

```erlang
function(parameter) when condition ->
```

- `Function(parameter)` - 这是在保护条件下使用的函数声明。
- `Parameter` - 通常，保护条件基于参数。
- `Condition`  - 应该评估条件以查看是否应该执行功能。
- 当指定了保护条件时，必须使用 `when` 语句。

让我们看一下如何使用 `Guard` 的简单示例-

```erlang
-module(helloworld). 
-export([display/1,start/0]). 

display(N) when N > 10 ->   
   io:fwrite("greater then 10"); 
display(N) when N < 10 -> io:fwrite("Less 
   than 10"). 

start() -> 
   display(11).
```

关于以上示例，需要注意以下几点：

- `display`函数与`guard`一起定义。
第一个显示声明具有参数`N`大于`10`的保护。
因此，如果参数大于`10`，则将调用该函数。

- 再次定义 `display` 函数。但是这一次的保护数少于10。这样，您可以多次定义相同的函数，每次都有单独的保护条件。


保护条件也可以用于 `if else` 和 `case` 语句。
让我们看看如何对这些语句执行保护操作。


## `if` 语句的防护

保护也可以用于 `if` 语句，以便执行的一系列语句基于保护条件。
让我们看看如何实现这一目标。

```erlang
-module(if_statement).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  N = 11,
  if
    N > 10 ->
      io:fwrite("N is greater than 10");
    true ->
      io:fwrite("N is less than 10")
  end.
```


## `case` 语句的防护

```erlang
-module(case_statement).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  A = 9,
  case A of {A} when 
    A > 10 -> io:fwrite("The value of A is greater than 10"); 
%%    default 
    _ -> io:fwrite("The value of A is less than 10")
  end.
```

## 多防护条件

也可以为一个功能指定多个保护条件。
下面给出了具有多个保护条件的保护语句的一般语法-

```erlang
function(parameter) when condition1 , condition1 , .. conditionN ->
```

让我们看一下如何使用多个守卫的简单示例-

```erlang
-module(multiple_condition).
-author("Administrator").

%% API
-export([start/0]).
display(N) when
  N > 10, is_integer(N) -> io:fwrite("greater then 10");
display(N) when
  N < 10 -> io:fwrite("Less than 10").

start() ->
  display(11).
```
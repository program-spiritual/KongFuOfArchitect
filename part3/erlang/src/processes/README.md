`Erlang` 中的并发粒度是一个进程。
进程是与其他进程同时运行并独立于其他进程的活动/任务。

`Erlang` 中的这些进程与大多数人熟悉的进程和线程不同。

`Erlang` 进程是轻量级的，与其他进程（内存中的）隔离运行，并且由 `Erlang` 的虚拟机（`VM`）调度。

进程的创建时间非常短，刚生成的进程的内存占用非常小，单个 `Erlang VM` 可以运行数百万个进程。

借助 `spawn` 方法创建一个进程。
该方法的一般语法如下。

语法：

```erlang
spawn(Module, Name, Args)
```

参数：

- `Module` - 这是一个预定义的原子值，必须为`?MODULE`
- `Name` - 这是定义进程时要调用的函数的名称。
- `Args` - 这些是需要发送给函数的参数  。

返回值：

返回创建的新进程的进程 `ID` 。

以下程序显示了 `spawn` 方法的示例。

```erlang

-module(hello).
-author("Administrator").

%% API
-export([call/2,start/0]).
call(Arg1, Arg2) ->
  io:format("~p ~p~n", [Arg1, Arg2]).
start() ->
  Pid = spawn(?MODULE, call, ["hello", "process"]),
  io:fwrite("~p~n",[Pid]).
```
## `is_process_alive`

这称为 `is_process_alive(Pid)`。
`Pid` 必须引用本地节点上的进程。
如果该进程存在并且还处于活动状态，
如果该进程存在并且仍在运行，则返回 `true` ，即不管它是否不退出并且尚未退出。
否则，返回 `false` 。


## `pid_to_list`

```erlang

-module(processes_pid_to_list).
-author("Administrator").

%% API
-export([call/2,start/0]).
call(Arg1, Arg2) ->
  io:format("~p ~p~n", [Arg1, Arg2]).

start() ->
  Pid = spawn(?MODULE, call, ["hello", "process"]),
  io:fwrite("~p~n",[pid_to_list(Pid)]).
```
## `registered`

> 返回所有已注册的进程列表

```erlang
-module(registered).
-author("Administrator").

%% API
-export([start/0]).
start() ->
%%  Returns a list with the names of all the registered processes.
  io:fwrite("~p~n", [registered()]).

```
## ‘`self`

> 返回正在调用的进程id  pid

```
-module(self_pid)
-export([start/0])

start()->
io:fwrite("~p~n",[self()]).

```

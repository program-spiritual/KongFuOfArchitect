
-module(hello).
-author("Administrator").

%% API
-export([call/2,start/0]).
call(Arg1, Arg2) ->
  io:format("~p ~p~n", [Arg1, Arg2]).
start() ->
  Pid = spawn(?MODULE, call, ["hello", "process"]),
  io:fwrite("~p~n",[Pid]).
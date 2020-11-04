-module(process_unregister).
-export([start/0,call/2]).

call(Arg1, Arg2) -> 
   io:fwrite("~p~n",[Arg1]). 
start() -> 
   Pid = spawn(?MODULE, call, ["hello", "process"]), 
   register(myprocess, Pid), 
   io:fwrite("~p~n",[whereis(myprocess)]), 
   unregister(myprocess), 
   io:fwrite("~p~n",[whereis(myprocess)]).

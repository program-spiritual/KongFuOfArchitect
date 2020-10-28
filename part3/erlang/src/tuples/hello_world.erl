-module(hello_world).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  P = {john,24,{june,25}} ,
  io:fwrite("~w",[tuple_size(P)]).
-module(is_tuple).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  P = {john,24,{june,25}} ,
  io:fwrite("~w",[is_tuple(P)]).
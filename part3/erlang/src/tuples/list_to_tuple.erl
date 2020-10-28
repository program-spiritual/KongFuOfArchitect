-module(list_to_tuple).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~w",[list_to_tuple([1,2,3])]).
-module(tuple_to_list).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~w",[tuple_to_list({1,2,3})]).

-module(binaries_binary_to_list).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n",[binary_to_list(<<2,1>>)]).
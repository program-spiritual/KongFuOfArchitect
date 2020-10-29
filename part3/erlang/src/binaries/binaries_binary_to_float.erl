
-module(binaries_binary_to_float).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n",[binary_to_float(<<"2.2">>)]).

-module(binaries_binary_to_integer).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n",[binary_to_integer(<<"2">>)]).

-module(binaries_is_binary).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n",[is_binary(<<1,2,3>>)]).
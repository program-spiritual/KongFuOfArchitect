
-module(binaries_binary_part).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n",[binary_part(<<1,2,3,4,5>>,{0,2})]).

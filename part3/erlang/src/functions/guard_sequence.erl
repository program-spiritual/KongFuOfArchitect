-module(guard_sequence).
-author("Administrator").

%% API
-export([add/1,start/0]).
add(X) when X>3 ->
  io:fwrite("~w~n",[X]).

start() ->
  add(4).
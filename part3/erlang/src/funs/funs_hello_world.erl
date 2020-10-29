
-module(funs_hello_world).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  A = fun() -> io:fwrite("Hello") end,
  A().
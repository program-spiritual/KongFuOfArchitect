
-module(macro_function).
-author("Administrator").

%% API
-export([start/0]).
-define(add(X,Y),{X+Y}).
start() ->
  io:fwrite("~w",[?add(1,2)]).
-module(variableWrongCase2).

%% API
-export([start/0]).
start() ->
  X = 40,
  Y = 50,
  X = 60,
  io:fwrite("~w",[X]).
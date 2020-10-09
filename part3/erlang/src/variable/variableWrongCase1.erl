%%%-------------------------------------------------------------------
-module(variableWrongCase1).

%% API
-export([start/0]).
start() ->
  X = 40,
  Y = 50,
  result = X + Y,
  io:fwrite("~w",[result]).

-module(variableCase1).
-author("Administrator").

%% API
-export([start/0]).
start()->
  X=40,
  Y=50,
  Result=X+Y,
  io:fwtite("~w",[Result]).
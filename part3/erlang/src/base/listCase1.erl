
-module(listCase1).

%% API
-export([start/0]).

start()->
  L=[10,20,30],
  io:fwrite("~w",[length(L)]).
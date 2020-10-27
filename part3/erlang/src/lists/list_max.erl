
-module(list_max).
-author("Administrator").
-import(lists,[max/1]).
%% API
-export([start/0]).
start()->
  Lst1 = [1,2,3,4],
  io:fwrite("~w~n",[max(Lst1)]).

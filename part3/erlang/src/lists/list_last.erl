
-module(list_last).
-author("Administrator").
-import(lists,[last/1]).
%% API
-export([start/0]).

start()->
  Lst1=[1,2,3,4],
  io:fwrite("~w~n",[last(Lst1)]).

-module(list_append).
-author("Administrator").
-import(lists,[append/2]).
%% API
-export([start/0]).
start()->
  Lst1 = [1,2,3],
  Lst2 = append(Lst1,[4,5]),
  io:fwrite("~w~n",[Lst2]).
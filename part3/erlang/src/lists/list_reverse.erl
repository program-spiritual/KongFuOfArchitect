
-module(list_reverse).
-author("Administrator").
-import(lists,[reverse/1]).
%% API
-export([start/0]).
start() ->
  Lst1 = [1,2,3],
  io:fwrite("~p~n",[reverse(Lst1)]).
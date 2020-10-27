
-module(list_deplicate).
-author("Administrator").
-import(lists,[duplicate/2]).
%% API
-export([]).
-export([start/0]).

start() ->
  Lst1 = duplicate(5,1),
  io:fwrite("~w~n",[Lst1]).
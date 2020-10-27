-module(list_sublist).
-author("Administrator").

%% API
-export([]).
start()->
  Lst1=[5,6,4],
  io:fwrite("~p~n",[lists:sublist(Lst1,2)]).
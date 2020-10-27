-module(list_sum).
-author("Administrator").

%% API
-export([start/0]).
start()->
  Lst1 = [5,6,4],
  io:fwrite("~p~n",[lists:sum(Lst1)]).
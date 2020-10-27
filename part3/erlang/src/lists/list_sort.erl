
-module(list_sort).
-author("Administrator").

%% API
-export([start/0]).

start()->
  List1 = [5,6,4],
  io:fwrite("~p~n",[lists:sort(List1)]).
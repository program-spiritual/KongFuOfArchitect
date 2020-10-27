-module(index).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  Lst1 = [1,2,3],
  io:fwrite("~w~n",[Lst1]).

-module(maps_from_list).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  Lst1 = [{"a",1},{"b",2},{"c",3}],
  io:fwrite("~p~n",[maps:from_list(Lst1)]).

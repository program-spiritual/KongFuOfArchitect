
-module(map_get).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  Lst1 = [{"a",1},{"b",2},{"c",3}],
  Map1 = maps:from_list(Lst1),
  io:fwrite("~p~n",[maps:get("a",Map1)]),
  io:fwrite("~p~n",[maps:get("b",Map1)]),
  io:fwrite("~p~n",[maps:get("c",Map1)]).
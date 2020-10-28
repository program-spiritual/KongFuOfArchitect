-module(map_remove).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  Lst1 = [{"a",1},{"b",2},{"c",3}],
  Map1 = maps:from_list(Lst1),
  io:fwrite("~p~n",[maps:remove("a",Map1)]).
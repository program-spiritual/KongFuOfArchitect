-module(maps_merge).
-author("Administrator").

%% API
-export([start/0]).
start()->
  Lst1 = [{"a",1},{"b",2},{"c",3}],
  Lst2 = [{"d",4},{"e",5},{"f",6}],

  Map1 = maps:from_list(Lst1),
  Map2 = maps:from_list(Lst2),
  io:fwrite("~p~n",[maps:merge(Map1,Map2)]).
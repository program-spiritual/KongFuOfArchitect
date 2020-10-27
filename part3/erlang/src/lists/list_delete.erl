
-module(list_delete).
-author("Administrator").

%% API
-export([start/0]).

start()->
  List1 = [1,2,3],
  List2 = lists:delete(3,List1),
  io:fwrite("~w~n",[List2]).

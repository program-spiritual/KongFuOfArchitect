
-module(list_member).
-author("Administrator").

%% API
-export([start/0]).
start()->
  Lst1=[1,2,3,4],
  io:fwrite("~w~n",[lists:member(3,Lst1)]).
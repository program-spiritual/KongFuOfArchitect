-module(list_any).
-author("Administrator").
-import(lists,[any/2]).
%% API
-export([start/0]).
start()->
  Lst1=[1,2,3],
  Predicate = fun(E)->E rem 2 == 0 end,
  Status = any(Predicate, Lst1),
  io:fwrite("~w~n",[Status]).

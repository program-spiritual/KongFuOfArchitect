
-module(duplicate).
-author("Administrator").

%% API
-export([duplicate/2,start/0]).
duplicate(0,_) ->
  [];
duplicate(N,Term) when N > 0 ->
  io:fwrite("~w,~n",[Term]),
  [Term|duplicate(N-1,Term)].
start() ->
  duplicate(5,1).
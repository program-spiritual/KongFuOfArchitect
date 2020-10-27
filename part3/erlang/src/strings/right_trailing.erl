-module(right_trailing).
-author("Administrator").
-import(string,[right/3]).
%% API
-export([start/0]).
start()->
  Str1 = "hello",
  Str2=right(Str1,10,$.),
  io:fwrite("~p~n",[Str2]).

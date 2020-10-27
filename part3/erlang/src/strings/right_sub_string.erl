-module(right_sub_string).
-author("Administrator").
-import(string,[right/2]).
%% API
-export([start/0]).
start()->
  Str1 = "hello World",
  Str2 = right(Str1,3),
  io:fwrite("~p~n",[Str2]).
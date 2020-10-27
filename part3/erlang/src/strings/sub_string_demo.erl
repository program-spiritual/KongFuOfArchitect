
-module(sub_string_demo).
-author("Administrator").
-import(string,[sub_string/3]).
%% API
-export([start/0]).
start()->
  Str1="hello world",
  Str2 = sub_string(Str1,1,15),
  io:fwrite("~p~n",[Str2]).
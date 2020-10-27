
-module(to_upper).
-author("Administrator").
-import(string,[to_upper/1]).
%% API
-export([start/0]).

start()->
  Str1 = "hello world",
  Str2 = to_upper(Str1),
  io:fwrite("~p~n",[Str2]).


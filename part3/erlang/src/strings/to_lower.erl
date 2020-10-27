-module(to_lower).
-author("Administrator").
-import(string,[to_lower/1]).
%% API
-export([start/0]).

start()->
  Str1 = "HELLO WORLD",
  Str2 =to_lower(Str1),
  io:fwrite("~p~n",[Str2]).

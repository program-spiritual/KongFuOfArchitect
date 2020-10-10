
-module(erlang_strings).
-author("Administrator").

%% API
-export([start/0,len_demo/0]).
start() ->
  Str1 = "This is a string",
  io:fwrite("~p~n",[Str1]).

len_demo()->
  Str1 = "This is a string1",
  Len1 = string:len(Str1),
  io:fwrite("~p~n",[Len1]).
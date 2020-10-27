-module(left_trailing).
-author("Administrator").
-import(string,[left/3]).
%% API
-export([start/0]).

start()->
%%   This is the string from which the sub string needs to be extracted
  Str1 = "hello",
%% Number  This is the number of characters which need to be present in the substring.
%%  $Character − The character to include as the trailing character.
  Str2 = left(Str1,10,$.),
  io:fwrite("~p~n",[Str2]).
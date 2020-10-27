
-module(erlang_strings).
-author("Administrator").
%% API
-export([start/0,len_demo/0,equal_demo/0,concat_demo/0,chr_demo/0]).
start() ->
  Str1 = "This is a string",
  io:fwrite("~p~n",[Str1]).

len_demo()->
  Str1 = "This is a string1",
  Len1 = string:len(Str1),
  io:fwrite("~p~n",[Len1]).

equal_demo()->
  Str1 = "This is a string1",
  Str2 = "This is a string2",
  Status = string:equal(Str1,Str2),
  io:fwrite("~p~n",[Status]).

concat_demo()->
  Str1 = "This is a ",
  Str2 = "string",
  Str3 = string:concat(Str1,Str2),
  io:fwrite("~p~n",[Str3]).

%% The method  chr returns the index position of a character in a string.
chr_demo()->
  Str1 = "hello world",
  Index1 = string:chr(Str1,$o),
  io:fwrite("~p~n",[Index1]).

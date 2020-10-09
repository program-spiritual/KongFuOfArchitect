-module(erlang_multiple_expression).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  A = 5,
  B = 6,
  if
    A == B ->
      io:fwrite("A is equal to B");
    A < B ->
      io:fwrite("A is less than B");
    true ->
      io:fwrite("False")
  end.
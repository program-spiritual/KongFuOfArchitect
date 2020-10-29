-module(multiple_condition).
-author("Administrator").

%% API
-export([start/0]).
display(N) when
  N > 10, is_integer(N) -> io:fwrite("greater then 10");
display(N) when
  N < 10 -> io:fwrite("Less than 10").

start() ->
  display(11).
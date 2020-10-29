-module(helloworld).
-export([display/1,start/0]).

display(N) when N > 10 ->
  io:fwrite("greater then 10");
display(N) when N < 10 -> io:fwrite("Less 
   than 10").

start() ->
  display(11).
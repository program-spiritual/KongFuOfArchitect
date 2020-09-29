% hello world program
-module(hello).
-export([start/0]).

start() ->
  io:fwrite("Hello, world!\n").
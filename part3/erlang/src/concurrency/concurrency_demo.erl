-module(concurrency_demo).
-export([start/0]).

start() ->
  spawn(fun() -> server("Hello") end).

server(Message) ->
  io:fwrite("~p",[Message]).
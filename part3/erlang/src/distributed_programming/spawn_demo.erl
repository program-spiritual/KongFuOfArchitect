-module(spawn_demo).
-export([start/0]).

start()->
  spawn(fun() -> server("hello") end).

server(Message)->
  io:fwrite("~p",[Message]).

-module(is_alive_demo).
-export([start/0]).

start()->
  io:fwrite("~p",[is_alive()]).

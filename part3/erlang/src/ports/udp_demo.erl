-module(udp_demo).
-export([start/0]).

start()->
  {ok,Socket} = gen_udp:open(8789),
  io:fwrite("~p",[Socket]).

-module(send_message_to_port).
-export([start/0]).

start()->
  {ok,Socket} = gen_udp:open(8789),
  io:fwrite("~p",[Socket]),
  io:fwrite("~p",[gen_udp:send(Socket,"localhost",8789,"Hello")]).

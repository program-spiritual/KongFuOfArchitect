-module(receive_message_from_port).
-export([start/0]).

start()->
  {ok,Socket} = gen_udp:open(8789),
  io:fwrite("~p",[Socket]),
  io:fwrite("~p",[gen_udp:send(Socket,"localhost",8789,"message to send!!1")]),
  io:fwrite("~p",[gen_udp:recv(Socket,20)]).



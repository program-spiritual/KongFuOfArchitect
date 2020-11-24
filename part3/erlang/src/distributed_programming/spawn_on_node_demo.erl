-module(spawn_on_node_demo).
-export([start/0]).

start()->
  spawn(node(),fun()->server("Hello") end).
  
server(Message)->
  io:fwrite("~p",[Message]).




  

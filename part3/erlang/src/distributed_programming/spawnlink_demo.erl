-module(spawnlink_demo).
-export([start/0]). 

start() -> 
   spawn_link(node(),fun() -> server("Hello") end). 

server(Message) ->
   io:fwrite("~p",[Message]).

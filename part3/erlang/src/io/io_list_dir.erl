-module(io_list_dir).
-author("Administrator").

%% API
-export([start/0]).
start()->
  io:fwrite("~p~n",[file:list_dir(".")]).
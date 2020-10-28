-module(io_is_file).
-author("Administrator").

%% API
-export([start/0]).
start()->
  io:fwrite("~p~n",[filelib:is_file("Renamedfile.txt")]),
  io:fwrite("~p~n",[filelib:is_file("newdir")]).
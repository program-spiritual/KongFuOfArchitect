
-module(io_is_dir).
-author("Administrator").

%% API
-export([start/0]).
start()->
  io:fwrite("~p~n",[filelib:is_dir("Renamedfile.txt")]),
  io:fwrite("~p~n",[filelib:is_dir("newdir")]).
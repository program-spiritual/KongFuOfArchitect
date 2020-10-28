
-module(io_file_size).
-author("Administrator").

%% API
-export([start/0]).
start()->
  io:fwrite("~w~n",[filelib:file_size("Renamedfile.txt")]).


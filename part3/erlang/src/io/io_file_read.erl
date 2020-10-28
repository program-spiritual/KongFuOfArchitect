
-module(io_file_read).
-author("Administrator").

%% API
-export([start/0]).
start()->
  Txt = file:read_file("Newfile.txt"),
  io:fwrite("~p~n",[Txt]).
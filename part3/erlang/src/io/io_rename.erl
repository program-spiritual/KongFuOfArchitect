-module(io_rename).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n",[file:rename("Newfile.txt","Renamedfile.txt")]).

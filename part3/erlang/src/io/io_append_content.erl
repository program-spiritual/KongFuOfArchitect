
-module(io_append_content).
-author("Administrator").

%% API
-export([start/0]).
start()->
  {ok, Fd} = file:open("NewFile.txt", [append]),
  file:write(Fd,"New Line").
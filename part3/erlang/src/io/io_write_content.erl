
-module(io_write_content).
-author("Administrator").

%% API
-export([start/0]).
start()->
  {ok, Fd} = file:open("writeFile.txt", [write]),
  file:write(Fd,"New Line").
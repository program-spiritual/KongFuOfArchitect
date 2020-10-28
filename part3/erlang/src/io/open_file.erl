-module(open_file).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  {ok, File} = file:open("./NewFile.txt",[read]),
  Txt = file:read(File,1024 * 1024),
  io:fwrite("~p~n",[Txt]).
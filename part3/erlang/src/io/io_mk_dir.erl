-module(io_mk_dir).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n", [file:make_dir("newdir")]).
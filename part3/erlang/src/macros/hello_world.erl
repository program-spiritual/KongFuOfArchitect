
-module(hello_world).
-author("Administrator").
-define(a,1).
%% API
-export([start/0]).
start() ->
  io:fwrite("~w",[?a]).
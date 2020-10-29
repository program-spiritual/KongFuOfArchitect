
-module(hello_world).
-author("Administrator").
-include("user.hrl").
%% API
-export([start/0]).
start()->
  io:fwrite("~w",[?add(1,2)]).
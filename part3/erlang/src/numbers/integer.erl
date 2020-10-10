
-module(integer).
-author("Administrator").

%% API
-export([start/0,floart/0]).
start() ->
  io:fwrite("~w",[1+1]).

floart()->
  io:fwrite("~w",[1.1+1.2]).
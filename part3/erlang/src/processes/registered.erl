
-module(registered).
-author("Administrator").

%% API
-export([start/0]).
start() ->
%%  Returns a list with the names of all the registered processes.
  io:fwrite("~p~n", [registered()]).
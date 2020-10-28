
-module(list_to_atom).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n",[list_to_atom("atom1")]).
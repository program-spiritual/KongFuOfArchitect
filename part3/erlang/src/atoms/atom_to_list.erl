
-module(atom_to_list).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n",[atom_to_list(atom1)]).
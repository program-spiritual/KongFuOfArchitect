-module(atom_to_binary).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n",[atom_to_binary('Erlang', utf8)]).

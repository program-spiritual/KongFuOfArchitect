-module(binary_to_atom).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~p~n",[binary_to_atom(<<"Erlang">>, latin1)]).

-module(atom_is_atom).
-author("Administrator").

%% API
-export([start/0]).
start()->
  io:fwrite(atom1),
  Atom1 = 12,
  io:fwrite(atom1),
  io:fwrite("~n"),
  io:fwrite("~p~n",[is_atom(atom1)]),
  io:fwrite("~p~n",[is_atom(Atom1)]).

-module(hello_world).
-author("Administrator").

%% API
-export([start/0]).
start()->
  io:fwrite(atom1),
  io:fwrite("~n"),
  io:fwrite(atom_1),
  io:fwrite("~n"),
  io:fwrite('atom 1'),
  io:fwrite("~n").
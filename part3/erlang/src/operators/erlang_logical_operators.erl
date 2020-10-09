
-module(erlang_logical_operators).
-author("Administrator").

%% API
-export([start/0]).
start()->
  io:fwrite("~w~n",[true or false]),
  io:fwrite("~w~n",[true and false]),
  io:fwrite("~w~n",[true xor false]),
  io:fwrite("~w~n",[not false]).
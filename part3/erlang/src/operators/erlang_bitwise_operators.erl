-module(erlang_bitwise_operators).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  io:fwrite("~w~n", [00111100 band 00001101]),
  io:fwrite("~w~n", [00111100 bxor 00111100]),
  io:fwrite("~w~n", [bnot 00111100]),
  io:fwrite("~w~n", [00111100 bor 00111100]).
-module(hello_world).
-author("Administrator").

%% API
-export([start/0, list_to_binary_demo/0, split_binary_demo/0, term_to_binary_demo/0]).
start() ->
%%  binary
  io:fwrite("~p~n", [<<5, 10, 20>>]),
  io:fwrite("~p~n", [<<"hello">>]).

list_to_binary_demo() ->
  io:fwrite("~p~n", [list_to_binary([1, 2, 3])]).

split_binary_demo() ->
  io:fwrite("~p~n", [split_binary(<<1, 2, 3, 4, 5>>, 3)]).

term_to_binary_demo() ->
  io:fwrite("~p~n", [term_to_binary("hello")]).
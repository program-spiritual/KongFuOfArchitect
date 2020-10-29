-module(hello_world).
-author("Administrator").

%% API
-export([
  start/0,
  date_demo/0,
  byte_size_demo/0,
  element_demo/0,
  float_demo/0,
  get_demo/0,
  put_demo/0,
  localtime_demo/0,
  memory_demo/0,
  now_demo/0,
  ports_demo/0,
  processes_demo/0,
  universaltime_demo/0
]).
start() ->
  io:fwrite("~p~n", [tuple_to_list({1, 2, 3})]),
  io:fwrite("~p~n", [time()]).
date_demo() ->
  io:fwrite("~p~n", [date()]).
byte_size_demo() ->
  io:fwrite("~p~n", [byte_size(<<1, 2, 3>>)]).
element_demo() ->
  io:fwrite("~p~n", [element(1, {a, b, c})]),
  io:fwrite("~p~n", [element(2, {a, b, c})]),
  io:fwrite("~p~n", [element(3, {a, b, c})]).
float_demo() ->
  io:fwrite("~p~n", [float(5)]).
get_demo() ->
  put(1, "One"),
  put(2, "Two"),
%%  The method returns the process dictionary as a list.
  io:fwrite("~p~n", [get()]).
put_demo() ->
%%  This method is used to put a key, value pair in the process dictionary.
  put(1, "One"),
  put(2, "Two"),
  io:fwrite("~p~n", [get()]).
localtime_demo() ->
  io:fwrite("~p~n", [erlang:localtime()]).
memory_demo() ->
  io:fwrite("~p~n", [erlang:memory()]).
now_demo() ->
  io:fwrite("~p~n", [erlang:now()]).
ports_demo() ->
  io:fwrite("~w~n", [erlang:ports()]).
processes_demo()->
  io:fwrite("~p~n",[erlang:processes()]).
universaltime_demo()->
  io:fwrite("~p~n ",[erlang:universaltime()]).
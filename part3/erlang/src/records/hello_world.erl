-module(hello_world).
-author("Administrator").

%% API
-export([start/0]).
-record(person, {name, id}).

start() ->
  P = #person{name = "John", id = 1},
  io:fwrite("~p~n", [P#person.id]),
  io:fwrite("~p~n", [P#person.name]),

  P1 = P#person{name = "Dan"},
  io:fwrite("~p~n", [P1#person.id]),
  io:fwrite("~p~n", [P1#person.name]).
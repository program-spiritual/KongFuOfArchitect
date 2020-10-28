-module(nested_records).
-author("Administrator").
-record(employee, {person, id}).
-record(person,{name="",address}).
%% API
-export([start/0]).
start()->
  P=#employee{person=#person{name="john james",address = "AAA"},id=1},
  io:fwrite("~p~n",[P#employee.id]),
  io:fwrite("~p~n",[P#employee.person]).



-module(funs_nested_func).
-author("Administrator").

%% API
-export([start/0]).
start()->
  Adder = fun(X) -> fun(Y) -> io:fwrite("~p~n",[X + Y]) end end,
  A = Adder(6),
  A(10).
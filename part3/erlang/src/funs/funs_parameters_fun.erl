
-module(funs_parameters_fun).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  A = fun(X) ->
    io:fwrite("~p~n",[X])
      end,
  A(5),
  A(232),
  A(111).
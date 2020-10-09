-module(erlang_case_statements).
-author("Administrator").
-import(io,[fwrite/1]).

%% API
-export([start/0]).
start()->
  A=5,
  case A of
    5->fwrite("The value of A is 5");
    6->fwrite("The value if A is 6")
  end.
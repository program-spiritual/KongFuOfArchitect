-module(bitStringCase1).
-import(io,[fwrite/2]).

%% API
-export([start/0]).
start() ->
  Bin1 = <<10,20>>,
%%  use built-in function binary_to_list to convert a Bit Strug to a list
  X = binary_to_list(Bin1),
  fwrite("~w",[X]).

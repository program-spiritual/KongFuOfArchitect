%%%-------------------------------------------------------------------
%%% @author xiaosanye
%%% @copyright (C) 2022, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 18. 9月 2022 02:11
%%%-------------------------------------------------------------------
-module(bit_string_type).
-author("xiaosanye").

%% API
-export([start/0]).
start() ->
  Bin2 = <<15,25>>,
  P = binary_to_list(Bin2),
  io:fwrite("~w",[P]).
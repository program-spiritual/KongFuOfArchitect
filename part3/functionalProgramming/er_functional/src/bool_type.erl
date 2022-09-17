%%%-------------------------------------------------------------------
%%% @author xiaosanye
%%% @copyright (C) 2022, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 18. 9月 2022 02:10
%%%-------------------------------------------------------------------
-module(bool_type).
-author("xiaosanye").

%% API
-export([start/0]).
start() ->
  io:fwrite(5 =< 9).

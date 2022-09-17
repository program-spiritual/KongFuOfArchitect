%%%-------------------------------------------------------------------
%%% @author xiaosanye
%%% @copyright (C) 2022, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 18. 9月 2022 02:14
%%%-------------------------------------------------------------------
-module(tuple_type).
-author("xiaosanye").

%% API
-export([start/0]).
start() ->
  K = {abc,50,pqr,60,{xyz,75}} ,
  io:fwrite("~w",[tuple_size(K)]).

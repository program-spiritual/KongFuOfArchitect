%%%-------------------------------------------------------------------
%%% @author huhongyun
%%% @copyright (C) 2022, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 18. 9月 2022 02:16
%%%-------------------------------------------------------------------
-module(list_type).
-author("huhongyun").

%% API
-export([start/0]).
start() ->
  List1 = [10,15,20,25,30] ,
  io:fwrite("~w",[length(List1)]).

%%%-------------------------------------------------------------------
%%% @author huhongyun
%%% @copyright (C) 2022, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 18. 9月 2022 02:15
%%%-------------------------------------------------------------------
-module(map_type).
-author("huhongyun").

%% API
-export([start/0]).
start() ->
  Map1 = #{name => 'abc',age => 40, gender => 'M'},
  io:fwrite("~w",[map_size(Map1)]).

%%%-------------------------------------------------------------------
%%% @author xiaosanye
%%% @copyright (C) 2022, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 06. 九月 2022 02:21
%%%-------------------------------------------------------------------
-module(numberType).
-author("xiaosanye").
%% API
-export([start/0,main/0]).
start()->io:fwrite("~w",[1+1]).
main() -> io:fwrite("~*.*.0f~n",[9, 5, 3.14159265]).

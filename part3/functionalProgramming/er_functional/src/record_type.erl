%%%-------------------------------------------------------------------
%%% @author xiaosanye
%%% @copyright (C) 2022, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 06. 十月 2022 13:10
%%%-------------------------------------------------------------------
-module(record_type).
-author("xiaosanye").
-record(student, {sname = "", sid}).
%% API
-export([start/0]).
start() ->
  S = #student{sname = "Sachin", sid = 5},
  io:fwrite("~p~n", [S#student.sid]),
  io:fwrite("~p~n", [S#student.sname]),
  S1 = S#student{sname = "Jonny"},
  io:fwrite("~p~n", [S1#student.sid]),
  io:fwrite("~p~n", [S1#student.sname]).

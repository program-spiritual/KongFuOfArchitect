
-module(erlang_relational_operators).
-author("Administrator").

%% API
-export([start/0]).
start()->
%%  等于
  io:fwrite("~w~n",[3==2]),
%%  不等于
  io:fwrite("~w~n",[3/=2]),
%%  小于
  io:fwrite("~w~n",[3<2]),
%%  小于等于
  io:fwrite("~w~n",[3=<2]),
%%  大于
  io:fwrite("~w~n",[3>2]),
%%  大于等于
  io:fwrite("~w~n",[3>=2]).
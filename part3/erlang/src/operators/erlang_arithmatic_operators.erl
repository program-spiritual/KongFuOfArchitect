
-module(erlang_arithmatic_operators).

%% API
-export([start/0]).
start()->
  X = 40,
  Y = 50,

  Res1 = X + Y,
  Res2 = X - Y,
  Res3 = X * Y,
  Res4 = X / Y,
  %%  div组件将执行除法并返回整数组件。
  Res5 = X div Y,
  %%  将第一个数字除以第二的余数
  Res6 = X rem Y,

  io:fwrite("~w~n",[Res1]),
  io:fwrite("~w~n",[Res2]),
  io:fwrite("~w~n",[Res3]),
  io:fwrite("~w~n",[Res4]),
  io:fwrite("~w~n",[Res5]),
  io:fwrite("~w~n",[Res6]).
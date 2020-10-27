-module(list_nth).
-author("Administrator").
%% 返回元素的序列
%% API
-export([start/0]).
start()->
  Lst1 = [1,2,3],
  io:fwrite("~p~n",[lists:nth(2,Lst1)]).
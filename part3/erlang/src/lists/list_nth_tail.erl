
%% 返回列表的第N个尾部，即从N + 1开始直到列表末尾的列表子列表
-module(list_nth_tail).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  Lst1 = [1,2,3],
  io:fwrite("~p~n",[lists:nthtail(2,Lst1)]).
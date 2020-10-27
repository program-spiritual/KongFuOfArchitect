
-module(list_merge).
-author("Administrator").
%%返回通过合并 ListOfLists 的所有子列表形成的排序列表。
%% API
-export([start/0]).
start()->
  io:fwrite("~w~n",[lists:merge([[1],[2],[3]])]).
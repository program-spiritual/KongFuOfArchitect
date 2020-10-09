
-module(anonymous).
-author("Administrator").
%% 使用 fun() 关键字定义匿名函数
%% 该功能分配给一个名为Fn的变量。
%% 通过变量名称调用函数。
%% API
-export([start/0]).
start()->
  Fn = fun()->
    io:fwrite("anonymous function") end,
  Fn().
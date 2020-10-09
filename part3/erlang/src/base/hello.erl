% hello world program
%% 声明的一般形式
%% 连字符（–）通常与模块，导入和导出语句一起使用。
%% 连字符用于为每个语句赋予相应的含义。
-module(hello).
-export([start/0]).

start() ->
  io:fwrite("Hello, world!\n").
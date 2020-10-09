
-module(length_recursion).
-author("Administrator").

%% API
-export([len/1,start/0]).
%% 如果列表为空，则将第一个函数len([])用于特殊情况
%%[H | T]模式以匹配一个或多个元素的列表
len([]) -> 0;
len([_|T]) -> 1 + len(T).
%% 请注意，第二个元素是列表本身。
%%这意味着我们只需要计算第一个元素，函数就可以在第二个元素上调用自身。
%%给定列表中的每个值的长度为1。
start() ->
  X = [1,2,3,4],
  Y = len(X),
  io:fwrite("~w",[Y]).
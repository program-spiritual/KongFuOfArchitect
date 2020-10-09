-module(forStatement).
%%我们正在定义一个递归函数，该函数将模拟我们的for循环的实现。
%%我们在“ for”功能中使用了保护措施，以确保N的值或限制为正值。
%%我们通过减少每次递归的N值来递归调用for函数。
%% API
-export([start/0]).
for(0, _) ->
  [];

for(N, Term) when N > 0 ->
  io:fwrite("Hello~n"),
  [Term | for(N - 1, Term)].

start() ->
  for(5, 1).
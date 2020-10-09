-module(whileStatement).
-author("Administrator").
%%需要注意以下要点
%% -定义一个名为 while 的递归函数，该函数将模拟 while 循环的实现。
%%作为示例，将变量X中定义的值列表输入到我们的while函数中。
%% while 函数获取每个列表值，并将中间值存储在变 量“ Acc” 中。
%%然后针对列表中的每个值递归调用 while 循环。
%% API
-export([while/1, while/2, start/0]).
while(L) -> while(L, 0).
while([], Acc) -> Acc;

while([_ | T], Acc) ->
  io:fwrite("~w~n", [Acc]),
  while(T, Acc + 1).

start() ->
  X = [1, 2, 3, 4],
  while(X).

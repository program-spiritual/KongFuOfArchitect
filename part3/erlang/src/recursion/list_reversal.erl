-module(list_reversal).
-author("Administrator").

%% API
-export([]).
tail_reverse(L) -> tail_reverse(L,[]).
tail_reverse([],Acc) -> Acc;
tail_reverse([H|T],Acc) -> tail_reverse(T, [H|Acc]).

%% 我们再次使用临时变量的概念将 `List` 的每个元素存储在 Acc 中。
%%我们tail_reverse调用，但这次，我们确保先将最后一个元素放在新列表中。
%%然后，我们为列表中的每个元素递归调用tail_reverse。
start() ->
  X = [1,2,3,4],
  Y = tail_reverse(X),
  io:fwrite("~w",[Y]).
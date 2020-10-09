
-module(erlang_nested_if_statements).
-author("Administrator").

%% API
-export([start/0]).
start() ->
  A = 4,
  B = 6,
%% 外层条件
  if
    A < B ->
      %%      开始嵌套
      if
        A > 5 ->
          io:fwrite("A is greater than 5");
        true ->
          io:fwrite("A is less than 5")
      end;
    true ->
      io:fwrite("A is greater than B")
  end.
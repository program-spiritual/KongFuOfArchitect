
-module(erlang_if_statement).
-author("Administrator").

%% API
-export([start/0]).
start()->
  A=5,
  B=6,
  if
%%    此处使用的表达式是变量 A 和 B 之间的比较。
%%    -> 运算符需要遵循表达式。
    A==B  ->
%%    ; 要紧随第一个语句
      io:fwrite("True");
%%    ->运算符需要遵循 true 的表达式。
    true ->
      io:fwrite("False")
%%  语句 “ end ” 必须在此处以表示 “ if ” 块的结尾。
  end.
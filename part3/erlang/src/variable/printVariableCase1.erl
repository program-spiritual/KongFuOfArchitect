%% 〜 -此字符表示需要对输出进行一些格式化。
%% 〜f -参数是一个浮点数，写为 [-]ddd.ddd，其中精度是小数点后的位数。
%%默认精度为6，并且不能小于1。
%% 〜n -这是将 println 换到新行。
%% 〜e -参数是一个浮点数，写为 [-]d.ddde+-ddd，其中 precision 是写入的位数。
%%缺省精度为6，且不能小于2。
-module(printVariableCase1).

%% API
-export([start/0]).
start()->
  X = 40.00,
  Y = 50.00,
  io:fwrite("~f~n",[X]),
  io:fwrite("~e",[Y]).

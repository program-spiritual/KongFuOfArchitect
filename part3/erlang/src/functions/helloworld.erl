
-module(helloworld).
-author("Administrator").
%%我们定义了两个函数，一个叫做 add ，它带有2个参数，另一个是 start 函数。
%% API
-export([add/2,start/0]).
add(X,Y)->
  Z=X+Y,
  io.file:write("~w~n",[Z]).


start()->
  add(5,6).
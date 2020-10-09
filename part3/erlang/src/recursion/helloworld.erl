-module(helloworld).
-author("Administrator").

%% API
-export([fac/1,start/0]).

fac(N) when N == 0 -> 1;
fac(N) when N > 0 -> N * fac(N - 1).

start()->
  X=fac(4),
  io:fwrite("~w",[X]).
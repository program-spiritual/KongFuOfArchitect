
-module(helloworld).

%% API
-export([start/0]).

start() ->
  io:fwrite("Hello World").
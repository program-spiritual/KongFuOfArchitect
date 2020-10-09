
-module(prebuilt_attribute).
-author("Administrator").
-version("1.0").
%% API
-export([start/0]).
start() ->
  io:fwrite("Hello World").
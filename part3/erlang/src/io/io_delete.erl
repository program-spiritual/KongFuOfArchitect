-module(io_delete).
-author("Administrator").

%% API
-export([start/0]).
start()->
  file:delete("Duplicate.txt").
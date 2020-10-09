-module(mapCase1).

%% API
-export([start/0]).
start()->
  M1 = #{name=>john,age=>25},
  io:fwrite("~w",[map_size(M1)]).
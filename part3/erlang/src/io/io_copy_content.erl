
-module(io_copy_content).
-author("Administrator").

%% API
-export([start/0]).
start()->
  file:copy("NewFile.txt","Duplicate.txt").


-module(booleanCase1).
-author("Administrator").

%% API
-export([start/0]).

start()->io:fwrite(2 =< 3).
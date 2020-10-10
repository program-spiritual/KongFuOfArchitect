
-module(mathematical_function).
-author("Administrator").

%% API
-export([sin/0,cos/0]).
sin()->
  Sin=math:sin(45),
  io:fwrite("~p~n",[Sin]).
cos()->
  Cosin = math:cos(45),
  io:fwrite("~p~n",[Cosin]).

-module(sleep_func_demo).

%% API
-export([start/0]).

sleep(T)->
  receive
  after T->
        true
  end.
start()->
  sleep(1000).  

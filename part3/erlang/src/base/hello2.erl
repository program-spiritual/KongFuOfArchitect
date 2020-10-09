%% hello world program
-module(hello2).
%% import function used to import the io module.
-import(io,[fwrite/1]).

%% API
%% export function used to ensure the start function can be accessed.
-export([start/0]).

start()->
  fwrite("Hello World! \n" ).
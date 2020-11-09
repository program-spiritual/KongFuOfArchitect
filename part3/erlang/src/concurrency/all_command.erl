
-module(all_command).
-export([loop/0,start/0]).

loop() ->
  receive
    {rectangle, Width, Ht} ->
      io:fwrite("Area of rectangle is ~p~n" ,[Width * Ht]),
      loop();
    {circle, R} ->
      io:fwrite("Area of circle is ~p~n" , [3.14159 * R * R]),
      loop();
    Other ->
      io:fwrite("Unknown"),
      loop()
  end.

start() ->
  Pid = spawn(fun() -> loop() end),
  Pid ! {rectangle, 6, 10}.

-module(complete_demo).
-export([start/0, client/1]).

start() ->
  spawn(fun() -> server(4000) end).

server(Port) ->
  {ok, Socket} = gen_udp:open(Port, [binary, {active, false}]),
  io:format("server opened socket:~p~n", [Socket]),
  loop(Socket).

loop(Socket) ->
  inet:setopts(Socket, [{active, once}]),
  receive
    {udp, Socket, Host, Port, Bin} ->
      io:format("server received:~p~n", [Bin]),
      gen_udp:send(Socket, Host, Port, Bin),
      loop(Socket)
  end.

client(N) ->
  {ok, Socket} = gen_udp:open(0, [binary]),
  io:format("client opened socket=~p~n", [Socket]),
  ok = gen_udp:send(Socket, "localhost", 4000, N), Value = receive
                                                             {udp, Socket, _, _, Bin} ->
                                                               io:format("client received:~p~n", [Bin]) after 2000 ->
                                                               0
                                                           end,

  gen_udp:close(Socket),
  Value.

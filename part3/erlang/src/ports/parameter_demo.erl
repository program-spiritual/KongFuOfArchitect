-module(parameter_demo).
-export([main/1]).

main(Args) ->
    io:format("Args: ~p\n", [Args]).

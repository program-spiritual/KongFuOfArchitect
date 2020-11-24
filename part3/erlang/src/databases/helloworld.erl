-module(helloworld). 
-export([start/0]). 

start() ->
   odbc:start(), 
   {ok, Ref} = odbc:connect("DSN = usersqlserver;UID = testuser;PWD = test123", []), 
   io:fwrite("~p",[Ref]).

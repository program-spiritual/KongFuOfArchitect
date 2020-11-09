-module(helloworld).
-export([start/0]).

start()->
  gen_smtp_client:send({"send@gmail.com",["receiver@gmail.com"],"Subject:testing"},
                       [{relay,"smtp.gmail.com"},{ssl,true},{username,"sender@gmail.com"},
                        {password,"senderpassword"}]).

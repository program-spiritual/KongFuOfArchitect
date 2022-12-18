%%%-------------------------------------------------------------------
%%% @author xxx
%%% @copyright (C) 2022, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 18. 十二月 2022 16:56
%%%-------------------------------------------------------------------
-module(write_to_file).
-author("xxx").

%% API
-export([start/0]).
start() ->
%%  注意 - 要打开我们必须使用的文件，打开（文件名，模式）。
  {ok, File1} = file:open("Tempfile2.txt", [write]),
%% 将内容写入文件的语法：write（filemode，file_content）。
  file:write(File1,"Writting contents to file"),
  io:fwrite("Data inserted into file\n").

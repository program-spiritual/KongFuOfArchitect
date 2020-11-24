-module(node_demo).
-export([start/0]).
%% 这将返回本地节点的名称。
%%如果未分配节点，则返回 nonode@nohost。

start()->
  io:fwrite("~p",[node()].

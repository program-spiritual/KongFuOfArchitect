单个 `atom` 是固定名称的字面量。
如果 `atom` 不是以小写字母开头，或者包含字母数字字符，
下划线（`_`）或`@`以外的其他字符，
则需要将其括在单引号（`'`）中。

实例：[hello_world](hello_world.erl)

```erlang

-module(hello_world).
-author("Administrator").

%% API
-export([start/0]).
start()->
  io:fwrite(atom1),
  io:fwrite("~n"),
  io:fwrite(atom_1),
  io:fwrite("~n"),
  io:fwrite('atom 1'),
  io:fwrite("~n").
```


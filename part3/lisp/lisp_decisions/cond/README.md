LISP中的cond构造最常用于允许分支。 cond的语法是-

```shell script

(cond   (test1    action1)
   (test2    action2)
   ...
   (testn   actionn))
```

`cond` 语句中的每个子句均由条件测试和要执行的动作组成。

如果 `cond test1 `之后的第一个测试的评估结果为true，则执行相关的动作部分action1，返回其值，其余子句将被跳过。

如果 `test1` 的值为 `nil` ，则控制移至第二个子句而不执行action1，并遵循相同的过程。

如果没有一个测试条件被评估为真，则 `cond` 语句返回 `nil` 。
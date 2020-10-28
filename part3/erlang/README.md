## Erlang Tutorial

### Erlang REPL
- `b()`  : 打印当前变量绑定。

- `f()`  : 删除所有当前变量绑定。

- `h()`  : 打印在 `shell` 程序中执行的所有命令的历史记录列表。

- `history(N)` : 将要保留在历史记录列表中的先前命令数设置为N。
### 基本数据类型

- `e(N)` 如果 N 为正，则重复命令 N 。
  如果为负，则重复第 N 个先前的命令


### 内置数据类型

- **Number**：  在 `Erlang` 中，有两种数字字面量，它们是整数和浮点数。

- **Atom**： 原子是字面量，是带名的常量。如果原子不是以小写字母开头，或者包含字母数字字符，下划线 `(_)` 或 `@` 以外的其他字符，则将其括在单引号 `(')` 中。

- **Boolean**：  Erlang中的布尔数据类型是两个保留的原子：`true` 和 `false` 。

- **Bit String**： 位字符串用于存储未定义类型的内存地址范围。

- **Tuple**：  元组是具有固定数量项的复合数据类型。元组中的每项称为元素。元素的数量被称为元组的大小。

- **Map**：  映射是具有可变数量的键值关联的复合数据类型。 映射中的每个键-值关联称为关联对。该对中的键和值部分称为元素。关联对的数量被称为映射的大小。

- **List**：列表是具有可变数量项的复合数据类型。 列表中的每项语称为一个元素。元素的数量被称为列表的长度。


## 文件目录
\part3\erlang\README.md
### 基础
- [hello](/part3/erlang/src/base/hello.erl)
- [hello2](/part3/erlang/src/base/hello2.erl)
- [atomCase1](/part3/erlang/src/base/atomCase1.erl)
- [numberCase1](/part3/erlang/src/base/numberCase1.erl)
### 变量
- [variableCase1](src/variable/variableCase1.erl)
- [variableWrongCase1](/part3/erlang/src/variable/variableWrongCase1.erl)
- [variableWrongCase2](/part3/erlang/src/variable/variableWrongCase2.erl)
- [printVariableCase1](/part3/erlang/src/variable/printVariableCase1.erl)
### 操作符
- [erlang_arithmatic_operators](/part3/erlang/src/operators/erlang_arithmatic_operators.erl)
- [erlang_bitwise_operators](/part3/erlang/src/operators/erlang_bitwise_operators.erl)
- [erlang_logical_operators](/part3/erlang/src/operators/erlang_logical_operators.erl)
- [erlang_relational_operators](/part3/erlang/src/operators/erlang_relational_operators.erl)
## 循环
- [forStatement](/part3/erlang/src/loops/forStatement.erl)
- [whileStatement](/part3/erlang/src/loops/whileStatement.erl)
### 决策
- [erlang_case_statements](/part3/erlang/src/decision/erlang_case_statements.erl)
- [erlang_if_statement](/part3/erlang/src/decision/erlang_if_statement.erl)
- [erlang_multiple_expression](/part3/erlang/src/decision/erlang_multiple_expression.erl)
- [erlang_nested_if_statements](/part3/erlang/src/decision/erlang_nested_if_statements.erl)
### 函数
- [anonymous](/part3/erlang/src/functions/anonymous.erl)
- [guard_sequence](/part3/erlang/src/functions/guard_sequence.erl)
- [guard_sequence](/part3/erlang/src/functions/guard_sequence.erl)
- [helloworld](/part3/erlang/src/functions/helloworld.erl)
- [multiple_args](/part3/erlang/src/functions/multiple_args.erl)

### 模块

- [attribute](/part3/erlang/src/module/attribute.erl)
- [helloworld](/part3/erlang/src/module/helloworld.erl)
- [import_module](/part3/erlang/src/module/import_module.erl)
- [prebuilt_attribute](/part3/erlang/src/module/prebuilt_attribute.erl)

### 递归

- [duplicate](/part3/erlang/src/recursion/duplicate.erl)
- [helloworld](/part3/erlang/src/recursion/helloworld.erl)
- [length_recursion](/part3/erlang/src/recursion/length_recursion.erl)
- [list_reversal](/part3/erlang/src/recursion/list_reversal.erl)
- [tail_recursion](/part3/erlang/src/recursion/tail_recursion.erl)

### 字符串

- [erlang_strings](/part3/erlang/src/strings/erlang_strings.erl)
- [left_trailing](/part3/erlang/src/strings/left_trailing.erl)
- [right_sub_string](/part3/erlang/src/strings/right_sub_string.erl)
- [right_trailing](/part3/erlang/src/strings/right_trailing.erl)
- [sub_string_demo](/part3/erlang/src/strings/sub_string_demo.erl)
- [to_lower](/part3/erlang/src/strings/to_lower.erl)
- [to_upper](/part3/erlang/src/strings/to_upper.erl)


### 列表

- [index](/part3/erlang/src/lists/index.erl)
- [list_all](/part3/erlang/src/lists/list_all.erl)
- [list_any](/part3/erlang/src/lists/list_any.erl)
- [list_append](/part3/erlang/src/lists/list_append.erl)
- [list_delete](/part3/erlang/src/lists/list_delete.erl)
- [list_deplicate](/part3/erlang/src/lists/list_deplicate.erl)
- [list_droplast](/part3/erlang/src/lists/list_droplast.erl)
- [list_last](/part3/erlang/src/lists/list_last.erl)
- [list_max](/part3/erlang/src/lists/list_max.erl)
- [list_member](/part3/erlang/src/lists/list_member.erl)
- [list_merge](/part3/erlang/src/lists/list_merge.erl)
- [list_min](/part3/erlang/src/lists/list_min.erl)
- [list_nth](/part3/erlang/src/lists/list_nth.erl)
- [list_nth_tail](/part3/erlang/src/lists/list_nth_tail.erl)
- [list_reverse](/part3/erlang/src/lists/list_reverse.erl)
- [list_sort](/part3/erlang/src/lists/list_sort.erl)
- [list_sublist](/part3/erlang/src/lists/list_sublist.erl)
- [list_sum](/part3/erlang/src/lists/list_sum.erl)


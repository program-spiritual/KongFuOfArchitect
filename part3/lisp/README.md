LISP表达式称为符号表达式或s表达式。s表达式由三个有效的对象，原子，列表和字符串组成。

任何s表达式都是有效程序。

LISP程序可以在解释器上运行，也可以作为已编译的代码运行。

解释器在重复循环中检查源代码，该循环也称为“读取-评估-打印”循环（REPL）。它读取程序代码，对其进行评估，然后打印该程序返回的值。


## 环境

- `vscode` 或 `EMACS`
- `clisp`
- `sbcl`


### windows clisp 

您可以从此处获取最新的 Windows CLISP- 

[windows CLISP](https://sourceforge.net/projects/clisp/files/latest/download)


### mac clisp

```
brew install clisp
```

在安装过程中，如果选择选项（RECOMMENDED），则`clisp`将自动添加到PATH变量中。这意味着您可以简单地打开一个新的Command Prompt窗口并键入“ clisp”来启动编译器。

要运行* .lisp或* .lsp文件，只需使用-

```
clisp hello.lisp
```

## 目录

[开始-hello-world](start/main.lisp)

[程序结构](./programConstruct/README.md)

[基础文法](./lisp_basic_syntax/README.md)

[宏](./lisp_macros/README.md)

[变量](./lisp_variables/README.md)

[运算符](./lisp_operators/README.md)

[条件语句](./lisp_decisions/README.md)

[函数](./lisp_function/)

[断言](./lisp_predicates/)

[条件语句](./lisp_decisions/)

[循环](./lisp_loops)

[数值类型](./lisp_numbers)

[字符串类型](./lisp_characters)

[队列](./lisp_sequences)

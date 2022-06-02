LISP程序由三个基本构建块组成-

- atom
- list
- string

原子是连续字符的数字或字符串。它包括数字和特殊字符。

以下是一些有效原子的示例-

```
hello-from-tutorials-point
name
123008907
*hello*
Block#221
abc123

```

列表是括号内的原子和/或其他列表的序列。
以下是一些有效列表的示例-

( i am a list)
(a ( a b c) d e fgh)
(father tom ( susan bill joe))
(sun mon tue wed thur fri sat)
( )

字符串是用双引号引起来的一组字符。

以下是一些有效字符串的示例-

```
" I am a string"
"a ba c d efg #$%^&!"
"Please enter the following details :"
"Hello from 'Tutorials Point'! "
```

## 添加注释

分号(;)用于指示注释行。

例如，

```lisp
(write-line "Hello World") ; greet the world

; tell them your whereabouts

(write-line "I am at 'Tutorials Point'! Learning LISP")
```

## 注意事项

LISP中的基本数字运算是+，-，*和/

LISP将函数调用f(x)表示为(fx)，例如cos(45)写为cos 45

LISP表达式不区分大小写，cos 45或COS 45相同。

LISP尝试评估所有内容，包括函数的参数。只有三种类型的元素是常量，并且总是返回自己的值

- Numbers

- 字母t代表逻辑上的真。

- 值nil(代表逻辑假)以及一个空列表。

## 关于LISP表格的更多信息

在上一章中，我们提到LISP代码的评估过程采取以下步骤。

- 读取器将字符串转换为LISP对象或s表达式。

- 评估程序定义从s表达式构建的Lisp表单的语法。第二层评估定义了一种语法，该语法确定哪些s表达式是LISP形式。

现在，可以使用LISP表格。

- 原子

- 空的或非列表

- 任何以符号为第一个元素的列表

评估器用作将有效LISP形式作为参数并返回值的函数。这就是为什么将LISP表达式放在括号中的原因，因为我们将整个表达式/表单作为参数发送给评估者。


## LISP中的命名约定

名称或符号可以由任意数量的字母数字字符组成，空格，开括号和右括号，双引号和单引号，反斜杠，逗号，冒号，分号和竖线除外。要在名称中使用这些字符，您需要使用转义字符（\）。

名称可以有数字，但不能完全由数字组成，因为这样它将被读为数字。同样，名称可以有句点，但不能完全由句点组成。

## 单引号的使用

LISP评估所有内容，包括函数参数和列表成员。

有时，我们需要按字面意义获取原子或列表，并且不希望它们被评估或视为函数调用。

为此，我们需要在原子或列表之前加上单引号。

以下示例对此进行了演示。

创建一个名为main.lisp的文件，然后在其中键入以下代码。

[main.lisp](main.lisp)

输出内容：

```lisp

(write-line "single quote used, it inhibits evaluation")
(write '(* 2 3))
(write-line " ")
(write-line "single quote not used, so expression evaluated")
(write (* 2 3))
```


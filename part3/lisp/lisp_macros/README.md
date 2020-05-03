宏允许您扩展标准LISP的语法。 从技术上讲，宏是一个将s表达式作为参数并返回LISP形式的函数，然后对其进行求值。


## 定义宏

在LISP中，使用另一个名为 `defmacro` 的宏定义了一个命名宏。定义宏的语法是-

```lisp
(defmacro macro-name (parameter-list))
"Optional documentation string."
body-form

```
宏定义由宏的名称，参数列表，可选的文档字符串和 `Lisp` 表达式主体组成，这些主体定义了要由宏执行的作业。

## 示例

让我们编写一个名为 `setTo10` 的简单宏，它将使用一个数字并将其值设置为 10。 创建名为main.lisp的新源代码文件，然后在其中键入以下代码。

[main.lisp](main.lisp)

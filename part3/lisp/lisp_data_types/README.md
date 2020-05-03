在LISP中，不键入变量，但键入数据对象。

LISP数据类型可以分类为。

- 标量类型 -例如，数字类型，字符，符号等。

- 数据结构 -例如，列表，向量，位向量和字符串。

除非您明确声明，否则任何变量都可以将任何 `LISP` 对象作为其值。

尽管不必为 `LISP` 变量指定数据类型，但是，它在某些循环扩展，方法声明以及我们将在后面的章节中讨论的某些其他情况下会有所帮助。

数据类型按层次结构排列。数据类型是 `LISP` 对象的集合，许多对象可能属于一个这样的集合。

- `typep` 谓词用于查找一个对象是否属于一个特定的类型。

- `type-of`  类型的函数返回一个给定对象的数据类型。

## LISP中的类型说明符

>  类型说明符是系统为数据类型定义的符号。

| atom    | float    | pathname     | simple-vector     |
| :------------- | :------------- | :------------- | :------------- |
| bignum       | function       | random-state       | single-float      |
|bit |	hash-table |	ratio	| standard-char |
| bit-vector | 	integer | 	rational | 	stream |
| character	 | keyword	 | readtable	 | string |
| [common] | 	list | 	sequence	 | [string-char] |
| compiled-function | 	long-float | 	short-float | 	symbol |
| complex | 	nill | 	signed-byte	 | t |
| cons | 	null	 | simple-array | 	unsigned-byte |
| double-float | 	number | 	simple-bit-vector	 | vector |


除了这些系统定义的类型之外，您还可以创建自己的数据类型。使用 `defstruct` 函数定义结构类型时，该结构类型的名称将成为有效的类型符号。

创建名为main.lisp的新源代码文件，然后在其中键入以下代码。

[main.lisp](./main.lisp)

接下来，让我们检查上一个示例中使用的变量的类型。创建名为main的新源代码文件。 lisp并在其中键入以下代码。
[main.lisp](./main2.lisp)

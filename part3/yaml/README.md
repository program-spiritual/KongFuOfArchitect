## YAML 


`YAML` 不是标记语言,而是一种数据序列化语言

### 格式

- `YAML` 大小写敏感
- 拓展名须以 `.yaml` 作为拓展名
- `YAML` 不允许在创建 YAML 文件时使用`tab`键；
  允许使用空格代替
  
### 基础文件格式

使用连接符和空格开头

[basic](basic.yaml)

```yaml
--- # Favorite movies
- Casablanca
- North by Northwest
- The Man Who Wasn't There
```

### 内联格式

内敛格式的分隔符使用逗号和空格

[inline](inline.yaml)

```yaml
--- # Shopping list
[milk, groceries, eggs, juice, fruits]
```

### 折叠文本

[folderText](foldText.yaml)

```yaml
---

-{ name:John, age:33}
-name:Mary Smith
 age:27

men:[John Smith,Bill Jones]
women:
  - Mary Smith
  - Susan Williams
```

### 基本元素

- 注释以 `#` 开头

- 注释必须通过空格与其他标记(tokens)分开。

- 空格的缩进用于表示结构

- `Tab` 键不作为 `YAML` 文件的缩进。

- 列表成员由前导连字符（`-`）表示。

- 列表成员括在方括号中，并用逗号分隔。

- 关联数组使用冒号`:`表示，以键值对的形式表示。
  它们用大括号`{}`括起来。
  
- 具有单个流的多个文档用3个连字符（`---`）分隔。

- 每个文件中重复的节点最初都以 `&` 号表示，之后再以星号`*`表示。  
  
- `YAML` 始终要求将冒号和逗号用作列表分隔符，后跟带有标量值的空格。

- 节点应标有感叹号（`!`）或双感叹号（`!!`），后跟可以扩展为URI或URL的字符串。

### 缩进和分隔符

#### 缩进

特性：
- 不包含强制空格符
- 空格不需要保持一致性

需要记住的准则：
- 流块必须至少与周围的当前块级别有一定距离。
- 跨越多行的`YAML`的流内容。
  流内容需以`{`或`[` 开头。

观察以下显示缩进示例的代码-

```yaml
--- !clarkevans.com/^invoice
invoice: 34843
date   : 2001-01-23
bill-to: &id001
   given  : Chris
   family : Dumars
   address:
      lines: |
            458 Walkman Dr.
            Suite #292
      city    : Royal Oak
      state   : MI
      postal  : 48046
ship-to: *id001
product:
    - sku         : BL394D
      quantity    : 4
      description : Basketball
      price       : 450.00
   - sku         : BL4438H
      quantity    : 1
      description : Super Hoop
      price       : 2392.00
tax  : 251.42
total: 4443.52
comments: >
    Late afternoon is best.
    Backup contact is Nancy
    Billsmer @ 338-4338.
```

#### 分割

- 字符串之间用双引号引起来。
- 如果您在给定的字符串中,转义换行符，它将被完全删除并转换为空值。

示例1：

在此示例中，我们集中列出了具有字符串数据类型的数组结构形式的动物。
列出的每个新元素都带有连字符前缀，如前所述。

```yaml
-
 - Cat
 - Dog
 - Goldfish
-
 - Python
 - Lion
 - Tiger
```
示例2：

此示例引用了一组错误消息，用户只需提及关键方面即可使用该错误消息并相应地获取值。 YAML的这种模式遵循JSON的结构

```yaml
errors:
      messages:
         already_confirmed: "was already confirmed, please try signing in"
         confirmation_period_expired: "needs to be confirmed within %{period}, please request a new one"
         expired: "has expired, please request a new one"
         not_found: "not found"
         not_locked: "was not locked"
         not_saved:
            one: "1 error prohibited this %{resource} from being saved:"
            other: "%{count} errors prohibited this %{resource} from being saved:"
```

### 注释信息

在YAML中如何增加注释消息呢？

注意事项：

- `YAML` 支持单行注释。
- `YAML` 不支持单行注释。

单行注释的方式：

```yaml
# this is single line comment.
```
如果你想使用多行注释，请参考以下的方式：

```yaml
# this
# is a multiple
# line comment
```

注释信息的特性：

- 在执行期间将被跳过
- 有助于添加指定代码块的描述
- 不得出现在标量内
- `YAML`不包含任何转义哈希符号（`＃`）的方法，在多行字符串中也是如此，因此无法将注释从原始字符串值分开。

下面来看一组示例：

```yaml
key: #comment 1
   - value line 1
   #comment 2
   - value line 2
   #comment 3
   - value line 3
```

### 集合和结构体

- `YAML` 包含了使用缩进作为作用域的块集合
- 每个条目都以新行开头。
- 集合中的块序列用破折号和空格（`-`）表示每个条目。
- 块集合样式没有任何特定的指示符。
- `YAML`中的块集合可以通过标识其中包含的键值对来区别于其他标量。

映射是`JSON`结构中包含的键值的表示形式。
它经常用于多语言支持系统中，并应用于移动应用程序，用来创建`API`。
映射使用冒号和空格（`:`)键值对表示形式。

示例1：

一个标量序列的示例，例如一个如下所示的球运动员列表

```yaml
- Mark Joseph
- James Stephen
- Ken Griffey
```

示例2：

以下示例显示了将标量映射到标量-

```yaml
hr: 87
avg: 0.298
rbi: 149
```

示例3：

以下示例显示将标量映射到序列（或称为数组序列）-

```yaml
European:
- Boston Red Sox
- Detroit Tigers
- New York Yankees

national:
- New York Mets
- Chicago Cubs
- Atlanta Braves
```

集合可用于序列（数组序列的）映射，如下所示-

```yaml
-
name: Mark Joseph
hr: 87
avg: 0.278
-
name: James Stephen
hr: 63
avg: 0.288
```

对于集合，`YAML` 包括使用显式指示符而不是使用缩进来表示空格的流样式。
集合中的流程顺序用方括号括起来的逗号分隔列表表示。 
`PHP` 框架（如 `Symphony` ）中包含的最佳收集插图。

```
[PHP, Perl, Python]
```

这些集合存储在文档中。 
`YAML` 中的文档分隔用三个连字符或破折号（`---`）表示。
文档末尾标有三个点（`...`）。

文档表示形式称为结构格式，在下面提到-

```yaml
# Ranking of 1998 home runs
---
- Mark Joseph
- James Stephen
- Ken Griffey 

# Team ranking
---
- Chicago Cubs
- St Louis Cardinals
```
带空格组合的问号表示结构上的复杂映射。
在图块集合中，用户可以包括带有破折号，冒号和问号的结构。
以下示例展示了序列之间的映射-

```yaml
- 2001-07-23
? [ New York Yankees,Atlanta Braves ]
: [ 2001-07-02, 2001-08-12, 2001-08-14]
```

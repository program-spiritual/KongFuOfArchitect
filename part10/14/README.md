## 笔记主要内容

### 用 `Antlr` 生成词法分析器和语法分析器

```shell script

antlr -visitor -package dsql.parser SQLite.g4
```

mac 如果是使用 brew install 安装，那么可：

```shell script


antlr4 -visitor -package dsql.parser SQLite.g4
```

### 测试一下所生成的词法分析器和语法分析器

我写了一个 `Test.java` 文件 并自己编译了一下，阁下可以自行编译并测试，也可以直接使用  `java` 运行

```shell script
## 编译

javac dsql/Test.java

## 运行

java dsql/Test 



```

### 输出

```sqlite
(sql_stmt (factored_select_stmt (select_core select (result_column (expr (column_name (any_name order_id)))) from (table_or_subquery (table_name (any_name orders))) where (expr (expr (column_name (any_name cust_id))) = (expr (literal_value 'SDYT987645'))))))

```
宫老师整理的格式：


```sqlite


(sql_stmt 
  (factored_select_stmt 
    (select_core select 
      (result_column 
        (expr 
          (column_name 
            (any_name order_id)))) 
      from (table_or_subquery 
              (table_name 
                (any_name orders)))
      where (expr 
              (expr 
                (column_name 
                  (any_name cust_id))) 
              = 
                (expr 
                  (literal_value 
                    ('SDYT987645'))))))
```

### 获取数据库的名称

完整实例在 `TestFull.java`


运行实例

```shell script
(sql_stmt (factored_select_stmt (select_core select (result_column (expr (column_name (any_name order_id)))) from (table_or_subquery (table_name (any_name orders))) where (expr (expr (expr (column_name (any_name cust_id))) = (expr (literal_value 'SDYT987645'))) and (expr (expr (column_name (any_name price))) > (expr (literal_value 200)))))))
[1694 1487 1585 641 225]
[1700 1126 78 78 1599 641 225]
sql:select order_id from orders where cust_id = 'SDYT987645' and price > 200
db:db1

```




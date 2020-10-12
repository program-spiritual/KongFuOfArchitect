## Scala 基础编程

> 这需要你有`java`的编程基础

- [基础语法](/part3/scala/scalaProgramming/HelloWorld.scala)
```scala
object HelloWorld {
  /* This is my first java program.
  * This will print 'Hello World' as the output
  */
  def main(args: Array[String]) {
    println("Hello, world!") // prints Hello World
  }
}
```
- [变量](./scala_variables.scala)
- [类和对象](scala_classes_objects.scala)
- [隐式类](IntTimesDemo.scala)
- 访问修饰符
  - [private](PrivateMember.scala)
  - [protected](ProtectMember.scala)
  - [public](PublicMember.scala)
  - [保护范围](Executive.scala)
- 运算符
  - [算数运算符](scala_arithmatic_operators.scala)
  - [关系运算符](scala_relational_operators.scala)
  - [逻辑运算符](scala_logical_operators.scala)
  - [按位运算符](scala_bitwise_operators.scala)
- IF-ELSE
  - [if语句](if_statement.scala)  
  - [if-else语句](if_else_statement.scala)
  - [if-else-if-else语句](if_else_if_else_statement.scala)
  - [nested-if-else语句](nested_if_else.scala)
- 循环语句
  - [while](scala_while_loop.scala)  
  - [do-while](scala_do_while_loop.scala)  
  - [for-loop-to](for_loop_to.scala)
  - [for-loop-until](for_loop_until.scala)
  - [for-loop-multiple-range](for_loop_multiple_range.scala)
  - [for-loop-with-collection](for_loop_with_collection.scala)
  - [for-loop-with-filter](for_loop_with_filters.scala)
  - [for-loop-with-yield](for_loop_with_yield.scala)
 - [函数](scala_functions.scala)
   - [functions_call_by_name](functions_call_by_name.scala)
   - [functions_named_arguments](functions_named_arguments.scala)
   - [functions_variable_arguments](functions_variable_arguments.scala)
   - [recursion_functions](recursion_functions.scala)
   - [functions_default_parameter_values](functions_default_parameter_values.scala)
   - [higher_order_functions](higher_order_functions.scala)
   - [nested_functions](nested_functions.scala)
   - [anonymous_functions](anonymous_functions.scala)
 - [闭包](scala_closures.scala)  
 - String 
   - [创建一个字符串](creating_a_string.scala)
   - [计算字符串的长度](string_length.scala)
   - [字符串连接](concatemating_string.scala)
   - [格式化字符串](creating_format_string.scala)
   - [字符串插值](string_interpolator.scala)
  - Array
    - [创建数组](creating_array.scala) 
    - [处理数组](processing_array.scala)
    - [多维数组](multi_dimensional_arrays.scala)
    - [串联数组](concatenate_array.scala)
    - [通过range创建一个数组](create_array_with_range.scala)
 - Collection
   - [List](create_list.scala)
     - [基础操作](base_operations_on_lists.scala)
     - [串联链表](concatenating_lists.scala)
     - [统一链表](creating_uniform_lists.scala)
     - [列出功能](tabulating_a_function.scala)
     - [反转列表顺序](reverse_list_order.scala)
   - [Set](base_operations_on_set.scala)  
     - [连接两个组](concatenating_set.scala)
     - [找到最小和最大的数](find_max_min_on_set.scala)
     - [找到两组之间的交集](find_common_values_between_two_set.scala)
   - [Map]
     - [基本操作](base_operation_on_map.scala)
     - [串联](concatenating_maps.scala)
     - [打印键 值](print_keys_and_values.scala)
     - [检查键是否存在](check_a_key_in_map.scala)
   - [Tuples]  
     - [创建一个元组](create_a_tuple.scala)
     - [使用元组](use_a_tuple.scala)
     - [遍历元组](iterate_over_the_tuple.scala)
     - [转换为字符串](converting_to_string.scala)
     - [交换元素](swap_element_on_tuple.scala)
   - [Option]  
     - [Option展示](show_option.scala)
     - [通过模式匹配拆分](./divide_by_pattern_mathch.scala)
     - [使用`getOrElse`设置默认值](use_get_or_else.scala)
     - [使用`isEmpty`方法](use_is_empty_on_option.scala)
   - [Iterator]
     - [直接迭代](use_iterator_with_while_loop.scala)  
     - [寻找最大最小值](find_max_min_on_iterator.scala)
     - [size length](size_len_on_iterator.scala)
     
 -Traits (特征)    
   >特征与`Java`中的抽象类非常相似。
   - [实现一个特征](implement_a_trait.scala)  
   - [值类与通用特征](value_and_universal_traits.scala)  
 - Pattern Matching
   > 每种备选方案均以关键字`case`开头。每个备选方案都包含一个模式和一个或多个表达式，如果模式匹配则将对其进行评估。箭头符号=>将模式与表达式分开
    
   - [案例1](matchTest.scala) 
   - [使用case classes](use_case_classes.scala)
 - Regular Expressions   
 我们创建一个String并在其上调用 `r()` 方法。 Scala隐式地将String转换为RichString并调用该方法以获取Regex的实例。
   - [案例1](use_regular_expressions.scala)
   - [案例2](use_regular_replace.scala)
   > 在Java和Scala中，单个反斜杠是字符串文字中的转义字符，而不是出现在字符串中的常规字符。因此，您需要编写“ \\”来代替字符串中的单个反斜杠，而不是“ \”。
   - [案例3](use_regular_expressions2.scala)
 - 异常处理
   - [案例1](catch_exception1.scala)  
   - [案例2](catch_exception2.scala)  
 - 提取器
 
   Scala中的提取器是一个对象，其成员之一具有称为unapply的方法。该不适用方法的目的是匹配值并将其拆开。通常，提取器对象还定义了适用于构建值的对偶方法，但这不是必需的
   - [案例1](extrctors_case1.scala)
   - [案例2-用提取器进行模式匹配](pattern_matching_with_extractors.scala)
 - 文件/IO
 
   Scala开放使用任何Java对象，而java.io.File是可在Scala编程中用于读取和写入文件的对象之一。
   - [案例1](file_io_case1.scala)  
   - [从命令行读取](reading_from_command_line.scala)
   - [读取文件内容](reading_file_content.scala)
   
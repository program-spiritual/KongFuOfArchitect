为了避免名字冲突，我们需要确定唯一的包名。推荐的做法是使用倒置的域名来确保唯一性。例如：

- org.apache
- org.apache.commons.log
- com.liaoxuefeng.sample
子包就可以根据功能自行命名。

要注意不要和java.lang包的类重名，即自己的类不要使用这些名字：

- String
- System
- Runtime
- ...

要注意也不要和JDK常用类重名：

- java.util.List
- java.text.Format
- java.math.BigInteger
- ...
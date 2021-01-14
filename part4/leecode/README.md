## 算法

1. 给出N生成括号的对数，写出一个函数并生成所有可能的有效括号组合。

[代码-py](src/main/java/first/Solution.py)

2. 剪枝

通常树或图的分支量非常庞大的时候，我们可以通过
- 优胜劣汰
- 优先级
- 最优解
  - 非常确定
  - 不太确定
      - 局部分支最优解遍历

的方式，解决完全遍历带来的复杂度问题

n 皇后问题：

将n个皇后放置在n*n 的棋盘上，并使皇后彼此之间不能互相攻击

[代码-py](src/main/java/second/Solution.py)

9*9 数独问题

将空白的地方填上1-9的其中一个数字并满足数独的规则：

[代码-java](./leecodeJ/src/main/java/second/Solution.java)


3. 二分查找法

前提:

1. 单调递增或单调递减
2. 存在上下限
3.能够通过索引访问
   
实现一个求解平方根的函数：

[代码-js](./src/main/java/third/Solution.mjs)
[代码-js-牛顿推导式](./src/main/java/third/SolutionV2.mjs)


4. 字典树



核心思想：

空间换时间。利用字符串的公共前缀降低查询时间的开销，以达到提高效率的目的。

实现一个字典树：

[代码-java-](./leecodeJ/src/main/java/fourth/)


给定单词数组，在面板上查找是否存在连续的字母可组成单词数组的单项。

[代码-java-](./leecodeJ/src/main/java/fourth/Solution.java)

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
2. 存在上下限 3.能够通过索引访问

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

5. 位运算

位运算本身是二进制位的运算 计算机的存储以及操作都是以二进制进行的

实际运用：

`X & 1` 判断二进制数的奇偶性
`X= X & (X-1)` 清零最低位的1
`X & -X ` 得到最低位的1

写一个函数，输入是一个无符号的整数，返回其二进制表达式中数字位为'1'的个数。

[代码-py-](./src/main/java/fifth/Solution.py)
[代码-java-](./src/main/java/fifth/Solution.mjs)

写一个函数 ，判断一个数是否是2的 n 次幂

[代码-py-](./src/main/java/fifth/Solution1.py)

写一个函数，生成对应范围 0-n 之内的每个位的二进制位 1的个数

[代码-js-](src/main/java/fifth/Solution2.mjs)

使用位运算解决N 皇后问题：

[代码-js-](src/main/java/fifth/Solution3.py)

6. 动态规划

1. 递归+ 记忆化 递推
2. 状态的定义
3. 状态的转移方程
4. 最优子结构

爬楼梯：

[代码-java-](./leecodeJ/src/main/java/sixth/Solution1.java)

三角形数组，求最小路径的和：

[代码-py-](./src/main/java/sixth/Solution.py)

乘积最大子序列：

[代码-py-](./src/main/java/sixth/Solution2.py)

买卖股票：

2 次：
[代码-py-](./src/main/java/sixth/Solution3.py)

最长上升自子序列：

[代码-java-](./leecodeJ/src/main/java/sixth/Solution4.java)

换硬币:

[代码-java-](./leecodeJ/src/main/java/sixth/Solution5.java)

编辑距离

[代码-py-](./src/main/java/sixth/Solution6.py)



7. 并查集

并查集是一种树形数据结构
作用：
处理不交集的合并及查询问题

Find: 确定元素属于哪个集合，确定两个元素是否属于同一个子集
Union: 将两个子集合并成一个集合。

[代码-java-](./leecodeJ/src/main/java/seventh/QuickUnionUF.java)


8. LRU Cache


1. 记忆
2. 钱包-储物柜
3. 代码模块

[代码-py-](./src/main/java/eighth/Solution.py)




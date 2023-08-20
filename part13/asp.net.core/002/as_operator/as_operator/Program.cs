// See https://aka.ms/new-console-template for more information

object[] array = new object[]
{
    1, "2", 3.1
};
// i的值为1  
int? i = array[0] as int?;
Console.WriteLine(i);
string s = array[1] as string;
Console.WriteLine(s);
// j的值为null，因为3.3不能转换为int，但不会引发异常
int? j = array[2] as int?;

object[] array2 = new object[] {3};

//as写法，代码简单易懂
int? num1 = array2[0] as int?;
if (num1 != null)
{
    Console.WriteLine(num1); //输出 3
}

//传统写法，代码冗长
int? num2 = null;
try
{
    num2 = (int?)array2[0];
}
catch
{
    num2 = null;
}
if (num2 != null)
{
    Console.WriteLine(num2);  //输出 3
}

// as运算符支持引用类型和可为null的值类型，但是对于不同值类型的转换，应该使用强制类型转换或者转型方法。
// 比如以下代码将字符串转为int、double转换为int：


// 编译错误：不能将字符串转换为整数
string ss = "11";  
// Program.cs(45, 11): [CS0039] Cannot convert type 'string' to 'int?' via a reference conversion,
// boxing conversion, unboxing conversion, wrapping conversion, or null type conversion
int? ii = ss as int?; 

//以下转换没有意义，d2永远为null
double d1 = 1.1;
int? d2 = d1 as int?;


//正确方法
int jj = int.Parse(ss);
int k = Convert.ToInt32(ss);
int d3 = (int)d1;
当程序终止时，我们需要文件来存储程序的输出。使用文件，我们可以使用不同语言的各种命令访问相关信息。以下是可以对文件执行的一些操作的列表 -

- 创建新文件
- 打开现有文件
- 读取文件内容
- 搜索文件上的数据
- 写入新文件
- 将内容更新到现有文件
- 删除文件
- 关闭文件

## 写入文件
要将内容写入文件，我们首先需要打开所需的文件。如果指定的文件不存在，则将创建一个新文件。让我们看看如何使用C++将内容写入文件。

[code](write_to_file.cpp)

注意：
- fstream 是用于控制文件读/写操作的流类。
- ofstream 是用于将内容写入文件的流类。

让我们看看如何使用 Erlang（一种函数式编程语言）将内容写入文件。

[code](write_to_file.erl)

输出 − 当我们运行此代码时，“将内容写入文件”将被写入文件 Tempfile.txt。如果文件有任何现有内容，则它将被覆盖。

## 从文件中读取

要从文件中读取，首先我们必须在读取模式下打开指定的文件。如果该文件不存在，则其各自的方法返回 NULL。以下程序演示如何以 C++ 读取−

```c++
#include <iostream> 
#include <fstream> 
#include <string> 
using namespace std;  

int main () {
   string readfile; 
   ifstream myfile ("Tempfile.txt",ios::in); 
   
   if (myfile.is_open()) {     
      while ( getline (myfile,readfile) ) {       
         cout << readfile << '\n'; 
      } 
      myfile.close(); 
   } else  
      cout << "file doesn't exist";  
   return 0; 
} 
```

[code](read_from_file.cpp)

它将产生以下输出 −

```text
Writing contents to file 
```

注意 −

在此程序中，我们使用“ios：：in”以阅读模式打开一个文本文件，然后将其内容打印在屏幕上。我们使用 while 循环通过使用“getline”方法逐行读取文件内容。


以下程序演示如何使用 Erlang 执行相同的操作。在这里，我们将使用 read_file（文件名） 方法从指定文件中读取所有内容。

```erlang
-module(helloworld).  
-export([start/0]).   

start() ->  
   rdfile = file:read_file("Tempfile.txt"),  
   io:fwrite("~p~n",[rdfile]).
```

它将产生以下输出 -

```text
Writing contents to file 
```

## 删除现有文件

我们可以使用文件操作删除现有文件。以下程序显示了如何使用 C++ - 删除现有文件

```c++
#include <stdio.h> 

int main () {   
   if(remove( "Tempfile.txt" ) != 0 ) 
      perror( "File doesn’t exist, can’t delete" ); 
   else 
      puts( "file deleted successfully " ); 
   return 0; 
}   
```
## 确定文件的大小

以下程序演示如何使用C++确定文件的大小。在这里，函数 fseek 将与流关联的位置指示器设置为新位置，而 ftell 返回流中的当前位置。

```c++
#include <stdio.h> 

int main () {  
   FILE * checkfile; 
   long size; 
   checkfile = fopen ("Tempfile.txt","rb"); 
   
   if (checkfile == NULL)  
      perror ("file can’t open"); 
   else {   
      fseek (checkfile, 0, SEEK_END);    // non-portable 
      size = ftell (checkfile); 
      fclose (checkfile); 
      printf ("Size of Tempfile.txt: %ld bytes.\n",size); 
   } 
   return 0; 
}    
```

输出 − 如果文件“Tempfile.txt”存在，那么它将显示其大小（以字节为单位）。


## 算法与数据结构基础课

### 环境准备 （C语言环境）

- windows  :  http://www.mingw.org/

- macos X : https://developer.apple.com/technologies/tools/

- linux/unix ：https://gcc.gnu.org/install/

#### windows 环境补充说明

鉴于windows的环境比较特殊，我们可以使用windows 的包管理工具进行安装。
我使用的工具为：`chocolatey  `
地址：https://chocolatey.org/

安装windows 环境依赖 `mingw`
```shell script
choco install mingw
```
安装完成之后，检测是否安装完成的方式是输入 
```shell script
gcc -v
 ```
我的输出结果：
```shell script
λ gcc -v                                                               
Using built-in specs.                                                  
COLLECT_GCC=C:\ProgramData\chocolatey\lib\mingw\tools\install\mingw64\b
in\gcc.exe                                                             
COLLECT_LTO_WRAPPER=C:/ProgramData/chocolatey/lib/mingw/tools/install/m
ingw64/bin/../libexec/gcc/x86_64-w64-mingw32/8.1.0/lto-wrapper.exe     
Target: x86_64-w64-mingw32                                             
Configured with: ../../../src/gcc-8.1.0/configure --host=x86_64-w64-min
gw32 --build=x86_64-w64-mingw32 --target=x86_64-w64-mingw32 --prefix=/m
ingw64 --with-sysroot=/c/mingw810/x86_64-810-posix-seh-rt_v6-rev0/mingw
64 --enable-shared --enable-static --disable-multilib --enable-language
s=c,c++,fortran,lto --enable-libstdcxx-time=yes --enable-threads=posix 
--enable-libgomp --enable-libatomic --enable-lto --enable-graphite --en
able-checking=release --enable-fully-dynamic-string --enable-version-sp
ecific-runtime-libs --disable-libstdcxx-pch --disable-libstdcxx-debug -
-enable-bootstrap --disable-rpath --disable-win32-registry --disable-nl
s --disable-werror --disable-symvers --with-gnu-as --with-gnu-ld --with
-arch=nocona --with-tune=core2 --with-libiconv --with-system-zlib --wit
h-gmp=/c/mingw810/prerequisites/x86_64-w64-mingw32-static --with-mpfr=/
c/mingw810/prerequisites/x86_64-w64-mingw32-static --with-mpc=/c/mingw8
10/prerequisites/x86_64-w64-mingw32-static --with-isl=/c/mingw810/prere
quisites/x86_64-w64-mingw32-static --with-pkgversion='x86_64-posix-seh-
rev0, Built by MinGW-W64 project' --with-bugurl=https://sourceforge.net
/projects/mingw-w64 CFLAGS='-O2 -pipe -fno-ident -I/c/mingw810/x86_64-8
10-posix-seh-rt_v6-rev0/mingw64/opt/include -I/c/mingw810/prerequisites
/x86_64-zlib-static/include -I/c/mingw810/prerequisites/x86_64-w64-ming
w32-static/include' CXXFLAGS='-O2 -pipe -fno-ident -I/c/mingw810/x86_64
-810-posix-seh-rt_v6-rev0/mingw64/opt/include -I/c/mingw810/prerequisit
es/x86_64-zlib-static/include -I/c/mingw810/prerequisites/x86_64-w64-mi
ngw32-static/include' CPPFLAGS=' -I/c/mingw810/x86_64-810-posix-seh-rt_
v6-rev0/mingw64/opt/include -I/c/mingw810/prerequisites/x86_64-zlib-sta
tic/include -I/c/mingw810/prerequisites/x86_64-w64-mingw32-static/inclu
de' LDFLAGS='-pipe -fno-ident -L/c/mingw810/x86_64-810-posix-seh-rt_v6-
rev0/mingw64/opt/lib -L/c/mingw810/prerequisites/x86_64-zlib-static/lib
 -L/c/mingw810/prerequisites/x86_64-w64-mingw32-static/lib '           
Thread model: posix                                                    
gcc version 8.1.0 (x86_64-posix-seh-rev0, Built by MinGW-W64 project)  
```

### 目录
- [基础知识脑图](./algorithms_basics.md)
- [渐进分析脑图](img/asymptotic_analysis.md)
- [贪婪算法](./greedy_algorithms.md)
- [分而治之](divide_and_conquer.md)
## 好书推荐

### 《C Primer Plus》

入门OOP和高级编程的必备，内容非常充实且含金量十足，是你居家旅行，驻场开发，熬夜撸代码必备之佳品！

![QQ图片20200109192749.jpg](https://static.nodejs7.com/2020/01/1810737903.jpg!750_375)





## 查看更多：

- [极客点子](http://geek.thickink.com/)
- [疯狂的AI](https://ai.nodejs7.com/)

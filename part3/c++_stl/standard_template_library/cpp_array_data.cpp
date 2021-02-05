/*
* C++函数std::array::data()返回一个指针,该指针指向数组容器的第一个元素。

当数组将所有元素存储在连续的内存位置中时,我们可以使用此Pointer对数组执行所有有效的操作。
**/

#include <iostream>
#include <array>

using namespace std;

int main(){
  array<char, 128> array = {"C++ standard library from tutorial of kongfu"};
  char *p, *q;
  p = array.data();
  cout << p << endl;
  q = p;
  while (*q) {
    cout << *q;
    ++q;
  }
}
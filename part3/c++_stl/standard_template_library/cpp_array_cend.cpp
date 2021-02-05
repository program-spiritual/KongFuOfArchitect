/*
* C++函数std::array::cend()返回一个常量迭代器,该迭代器指向array的过去元素。
   此方法返回的迭代器可用于迭代数组内容,但即使数组对象本身不是常量,也不能用于修改数组内容。
**/

#include <iostream>
#include <array>

using namespace std;

int main(){
  array<int, 5> array = {1, 2, 3, 4, 5};
  auto ptr = array.cend();

// 错误：尝试修改将导致编译错误
  *ptr = 500;
}
/*
 C++函数std::array::cbegin()返回一个常量迭代器,该迭代器指向数组的开头。
此方法返回的迭代器可用于迭代容器,但不能用于修改数组内容。
**/

#include <iostream>
#include <array>

using namespace std;

int main(){
  array<int, 5> arr = {1, 2, 3, 4, 5};
  auto it = arr.cbegin();

  /* iterate whole array*/
  while (it < arr.end()) {
    cout <<*it << " ";
    /*
    *  由于此方法返回const迭代器,因此我们无法使用此迭代器来修改数组内容。
    *   任何试图修改数组元素的尝试都会报告编译错误。
   **/
   *it = 100;
    ++it;
  }

  cout << endl;



}
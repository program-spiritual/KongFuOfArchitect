/*
* C++函数std::array::crbegin()返回一个常量反向迭代器,该迭代器指向数组的最后一个元素。
**/

#include <iostream>
#include <array>

using namespace std;

int main(){
  array<int, 5> array = {1, 2, 3, 4, 5,};
  for (auto it=array.crbegin()  ; it!=array.crend() ; ++it) {
    cout << *it << " ";
  }
}
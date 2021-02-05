/**
* C++函数std::array::back() 返回对数组容器最后一个元素的引用。
* 此方法返回最后一个数组元素本身,在空数组容器上调用此方法将导致未定义的行为。
*/

#include <iostream>
#include <array>

using namespace std;

int main(){
  array<int, 5> arr = {1, 2, 3, 4, 5};
  cout << "last element of array is : " << arr.back();
  // 修改末尾的值
  arr.back()=50;
  // 打印修改后的值
  cout << "after modification last element of array = " << arr.back()
       << endl;
}

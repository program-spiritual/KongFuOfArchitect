//C++函数std::array::empty()测试数组的大小是否为零。

#include <iostream>
#include <array>

using namespace std;

int main(void) {

  /* array size is zero, it will be treated as empty array*/
  array<int, 0> arr1{};
  array<int, 10> arr2{};

  if (arr1.empty())
    cout << "arr1 is empty" << endl;
  else
    cout << "arr1 is not empty" << endl;

  if (arr2.empty())
    cout << "arr2 is empty" << endl;
  else
    cout << "arr2 is not empty" << endl;
}
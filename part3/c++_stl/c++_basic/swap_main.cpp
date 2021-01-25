#include <iostream>
using namespace std;

// 函数声明
void swap(int x, int y);

int main () {
  // 本地变量声明:
  int a = 100;
  int b = 200;

  cout << "Before swap, value of a :" << a << endl;
  cout << "Before swap, value of b :" << b << endl;

  // 交换变量的值.
  swap(a, b);

  cout << "After swap, value of a :" << a << endl;
  cout << "After swap, value of b :" << b << endl;

  return 0;
}
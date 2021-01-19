#include <iostream>

using namespace std;

// 全局变量
int g;

int main() {
// 本地变量
  int a, b;
// 实际初始化
  a = 10;
  b = 20;
  g=a+b;
  cout << g << endl;
  return 0;
}
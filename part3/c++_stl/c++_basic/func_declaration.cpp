#include <iostream>

using namespace std;
// 函数声明
int func();

int main(){
  // 函数调用
  int i = func();
  cout << i << endl;
  return 0;
}
// 函数定义
int func(){
  return 12;
}



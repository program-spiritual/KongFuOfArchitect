#include <istream>
#include <iostream>

using namespace std;

// 函数声明

int max(int, int);


int main(){
// 本地变量
  int a = 100;
  int b = 200;
  int ret ;
  // 调用函数
  ret  = max(a,b);
  cout << "Max value is : " << ret << endl;
  return 0;
}

int max(int num1, int num2) {
  return num1 > num2 ? num1 : num2;
}
#include <iostream>

using namespace std;

// 函数声明
void func();
// 全局变量
static int count = 10;

int main(){
  while(count--) {
    func();
  }
}

// 函数定义

void func(){
  static int  i = 5; // 本地静态变量
  i++;
  std::cout << "i is " << i ;
  std::cout << " and count is " << count << std::endl;
}
#include <iostream>
#include <ctime>
#include <cstdlib>

using namespace std;

int main(){
  int i,j;
  // 设置种子
  srand((unsigned )time(nullptr));
  for (i=0; i < 10; ++i) {
    // 生成实际随机数
    j = rand();
    cout <<" Random Number : " << j << endl;
  }
}

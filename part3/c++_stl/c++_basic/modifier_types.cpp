#include <iostream>

using namespace std;

/*
 * 无符号整型和有符号整型的区分
 * */

int main() {
  short int i; // 有符号的短整数
  short unsigned int j; // 无符号短整型
  j = 50000;
  i = j;
  cout << i << " " << j << endl;
  auto x = 10;
  cout << x << endl;
  register int  miles;
  cout << miles << endl;
  return 0;
}
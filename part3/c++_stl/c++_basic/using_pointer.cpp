#include <iostream>

using namespace std;


int main(){
  int var =20;
  int *ip;
  ip = &var; // 在指针变量中存储var的地址
  cout << "Value of var variable: ";
  cout << var << endl;
  // 打印存储在ip指针变量中的地址
  cout << "Address stored in ip variable: ";
  cout << ip << endl;
  // 访问指针中可用地址的值
  cout << "Value of *ip variable: ";
  cout << *ip << endl;
}
#include <iostream>
#include <new>
using namespace std;
struct MyClass{
  int data{};

  MyClass() { cout << '@'; }
};

int main(){
  std::cout << "constructions (1): ";
  auto * p1 = new MyClass[10];
  std::cout << '\n';

  std::cout << "constructions (2): ";
  auto * p2 = new (std::nothrow) MyClass[5];
  std::cout << '\n';

  delete[] p2;
  delete[] p1;
}
#include <iostream>
#include <new>

using namespace std;
struct MyClass{
  int data[100]{};
  MyClass() { cout << "it constructed [" << this << "]"; }
};

int main(){
  cout << "1:";
  auto *p1 = new MyClass;
  cout << "2:";
  auto *p2 = new(nothrow) MyClass;
  cout << "3:";
  new(p2) MyClass;
  cout << "4:";
  auto *p3 = (MyClass*) ::operator new(sizeof(MyClass));
  delete p1;
  delete p2;
  delete p3;
}

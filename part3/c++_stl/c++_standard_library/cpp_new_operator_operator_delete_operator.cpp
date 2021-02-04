#include <iostream>
#include <memory>
using namespace std;
struct MyClass{
  MyClass() {std::cout <<"MyClass is constructed\n";}
  ~MyClass() {std::cout <<"MyClass is destroyed\n";}
};

int main(){
  MyClass *pt;
  pt = new MyClass[3];
  delete[] pt;

}
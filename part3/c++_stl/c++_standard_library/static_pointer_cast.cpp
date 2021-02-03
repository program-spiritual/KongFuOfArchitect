#include <iostream>
#include <memory>
using namespace std;
struct BaseClass{

};

struct DerivedClass:BaseClass{
  static void f() {
    std::cout << "Sample word!\n";
  }
};

int main(){
  shared_ptr<BaseClass> ptr_to_base(make_shared<DerivedClass>());
  static_pointer_cast<DerivedClass>(ptr_to_base)->f();
  static_cast<DerivedClass *> (ptr_to_base.get())->f();
}
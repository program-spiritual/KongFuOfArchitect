#include <iostream>
#include <memory>

using namespace std;
struct D {
  void operator()(const int *p) {
    cout << "[deleter called]\n";
    delete[] p;
  }
};

int main(){
  shared_ptr<int> foo(new int[10], D());
  int *bar = new int[20];
  (*get_deleter<D>(foo))(bar);
}
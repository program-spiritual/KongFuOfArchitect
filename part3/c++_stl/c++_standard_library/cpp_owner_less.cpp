#include <memory>
#include <iostream>
#include <set>
using namespace std ;
int main(){
  int *p = new int[10];
  shared_ptr<int> a(new int(20));
  shared_ptr<int> b (a, p);
  set <shared_ptr<int>> value_based;
  set <shared_ptr<int>,owner_less<shared_ptr<int>>> owner_based;
  value_based.insert(a);
  value_based.insert(b);
  owner_based.insert(a);
  owner_based.insert(b);
  std::cout << "value_based.size() is " << value_based.size() << '\n';
  std::cout << "owner_based.size() is " << owner_based.size() << '\n';
  delete[] p;

}
#include <iostream>
#include <new>

using namespace std;
int main(){
  cout << "attempting to allocate ...";
  char *p = new(nothrow) char[1024 * 1024];
  if (nullptr==p) { cout << "Failed"; }
  else{
    std::cout << "Succeeded!\n";
    delete[] p;
  }
}
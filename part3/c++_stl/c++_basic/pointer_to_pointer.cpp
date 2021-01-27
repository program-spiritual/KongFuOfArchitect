#include <iostream>

using namespace std;

int main(){
  int var;
  int *p;
  int **pp;
  var=300;
  p = &var;
  pp=&p;
  cout << "val of var:" << var <<endl;
  cout << "val of p:" << *p <<endl;
  cout << "address of p:" << *pp <<endl;
  cout << "val of p:" << **pp <<endl;
}
#include <iostream>

using namespace std;


int main(){
  const int MAX = 3;
  int var[MAX] = {100,200,300};
  int *p;
  p=var;
  int i =0;
  while (p < &var[MAX - 1]) {
    cout << "Address of var[" << i << "] = ";
    cout << p << endl;
    cout << "Value of var[" << i << "] = ";
    cout << *p << endl;

    p++;
    i++;
  }
}
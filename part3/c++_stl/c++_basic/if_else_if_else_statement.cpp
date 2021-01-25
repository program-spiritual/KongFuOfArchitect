#include <iostream>

using namespace std;

int main(){
  int a = 100;
  if (a==10) {cout << "value is:" << a <<endl;}
  else if (a==20) {cout << "value is:" << a <<endl;}
  else if (a==30) {cout << "value is:" << a <<endl;}
  else{
    cout << "Value of a is not matching" << endl;
  }
  cout << "Exact value of a is : " << a << endl;
}
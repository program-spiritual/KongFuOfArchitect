#include <iostream>

using namespace std;

int main(){
  // local variable declaration:
  int a = 100;

  // check the boolean condition
  if( a < 20 ) {
    // if condition is true then print the following
    cout << "a is less than 20;" << endl;
  } else {
    // if condition is false then print the following
    cout << "a is not less than 20;" << endl;
  }
  cout << "value of a is : " << a << endl;

  return 0;
}
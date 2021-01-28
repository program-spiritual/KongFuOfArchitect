#include <iostream>

using namespace std;

int main(){
  char greeting[] = "Hello";
  char *p = greeting;
  cout << "p:" << p <<endl;
  for (int i = 0; i < sizeof(greeting) ;++i) {
    cout << "address:" << (p+i) <<endl;
    cout << "val:" << *(p+i) <<endl;
    cout << "i:" << i <<endl;
  }
}

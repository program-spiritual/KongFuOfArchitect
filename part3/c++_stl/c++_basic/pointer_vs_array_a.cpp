#include <iostream>

using namespace std;

int main(){
  const int MAX = 3;
  int var[MAX]  ={10,100,200};
  int *p ;
  p = var;
  for (int i = 0; i < MAX; ++i) {
    cout <<"address:" << p<<endl;
    cout <<"val:" << *p<<endl;
    p++;
  }
}
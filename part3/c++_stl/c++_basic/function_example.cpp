#include <iostream>
using namespace std;
int max(int num1, int num2){
  return num1 > num2 ? num1 : num2;
}

int min(int, int);

int main(){
  int res = max(10, 2);
  cout << res << endl;
}
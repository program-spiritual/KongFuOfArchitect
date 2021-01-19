#include <iostream>

using namespace std;

#define LENGTH 10

#define WIDTH 5

#define NEWLINE '\n'

int main(){
  int area;
  area = LENGTH * WIDTH;
  cout << area ;
  cout << NEWLINE;
  const int L = 100;
  const int W = 10;
  int newArea = 0;
  newArea = L * W;
  cout << newArea << endl;
  return 0;
}
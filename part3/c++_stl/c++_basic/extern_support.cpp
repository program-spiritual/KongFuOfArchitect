#include <iostream>

using namespace std;

extern int count;

void write_extern(){
  cout << "Count is:" << count << endl;
}
#include <iostream>
#include <ctime>

using namespace std;

void getSeconds(unsigned long *par);

int main() {
  unsigned long sec;
  getSeconds(&sec);
  // print the actual val
  cout << "Number of seconds :" << sec << endl;

}

void getSeconds(unsigned long *par) {
  // get the current number of seconds.
  *par = time(nullptr);
}

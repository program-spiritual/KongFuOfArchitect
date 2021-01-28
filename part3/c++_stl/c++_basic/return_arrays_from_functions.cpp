#include <iostream>
#include <ctime>

using namespace std;

int* getRandom(){
  static int  r[10];

  // set the seed
  srand( (unsigned)time( nullptr ) );

  for (int i = 0; i < 10; ++i) {
    r[i] = rand();
    cout << r[i] << endl;
  }

  return r;
}

int main(){
  int *p;

  p = getRandom();

  for ( int i = 0; i < 10; i++ ) {
    cout << "*(p + " << i << ") : ";
    cout << *(p + i) << endl;
  }
}
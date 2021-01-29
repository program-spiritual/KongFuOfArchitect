#include <iostream>
using namespace std;
const int SIZE = 10;

class safearay {
private:
  int arr[SIZE]{};

public:
  safearay() {
     int i;
    for(i = 0; i < SIZE; i++) {
      arr[i] = i;
    }
  }

  int &operator[](int i) {
    if( i > SIZE ) {
      cout << "Index out of bounds" <<endl;
      // return first element.
      return arr[0];
    }

    return arr[i];
  }
};

int main() {
  safearay A;

  cout << "Value of A[2] : " << A[2] <<endl;
  cout << "Value of A[5] : " << A[5]<<endl;
  cout << "Value of A[12] : " << A[12]<<endl;

  return 0;
}
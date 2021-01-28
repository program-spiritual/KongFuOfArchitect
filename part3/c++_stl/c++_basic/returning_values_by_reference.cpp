#include <iostream>
#include <ctime>

using namespace std;

double vals[] = {10.1, 12.6, 33.1, 24.1, 50.0};

double &setValues(int i) {
  return vals[i]; // return a reference to the ith element
}

// main function to call above defined function

int main() {
  cout << "Value before change" << endl;
  for (int i = 0; i < 5; i++) {
    cout << "vals[" << i << "] = ";
    cout << vals[i] << endl;
  }

  setValues(1) = 20.23; // change 2nd element
  setValues(3) = 70.8;  // change 4th element

  cout << "Value after change" << endl;
  for ( int i = 0; i < 5; i++ ) {
    cout << "vals[" << i << "] = ";
    cout << vals[i] << endl;
  }
}
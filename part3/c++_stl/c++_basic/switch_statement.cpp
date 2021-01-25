#include <iostream>

using namespace std;

int main() {
  char grade = 'D';
  switch (grade) {
    case 'A':
      cout << "666" << endl;
      break;
    case 'B':
    case 'C':
      cout << "bacuo" << endl;
      break;
    case 'D':
      cout << "you passed" << endl;
      break;
    case 'F' :
      cout << "Better try again" << endl;
      break;
    default :
      cout << "Invalid grade" << endl;
  }
  cout << "Your grade is " << grade << endl;

  return 0;
}
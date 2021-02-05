#include <iostream>
#include <array>

using namespace std;

int main(){
  array<int, 3> arr1 = {10, 20, 30};
  array<int, 3> arr2 = {51, 52, 53};
  cout << "Contents of arr1 and arr2 before swap operation\n";
  cout << "arr1 = ";
  for (int &i : arr1) cout << i << " ";
  cout << endl;

  cout << "arr2 = ";
  for (int &i : arr2) cout << i << " ";
  cout << endl << endl;

  arr1.swap(arr2);

  cout << "Contents of arr1 and arr2 after swap operation\n";
  cout << "arr1 = ";
  for (int &i : arr1) cout << i << " ";
  cout << endl;

  cout << "arr2 = ";
  for (int &i : arr2) cout << i << " ";
  cout << endl;

  return 0;
}
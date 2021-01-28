#include <iostream>

#include <cstring>

using namespace std;

int main(){
  char str1[10] = "Hello";
  char str2[10] = "World";
  char str3[10];
// copy str1 to str3
  strcpy(str3, str1);
  cout << "str3:" << str3 << endl;
//  concat str1 and str2
  strcat(str1, str2);
  cout << "str1:" << str1  <<endl;
//  str length
  cout << strlen(str1) << endl;
}
#include <iostream>

using namespace std;

// 函数声明
double getAverage(const int *arr,int size);
int main(){
// 一个整型元素数组
  int balance[5] = {100, 2, 3, 17, 50};
  double avg;
//  传递指针到数组作为参数
  avg = getAverage( balance, 5 ) ;

  cout << "Average value is: " << avg << endl;
}

double getAverage(const int *arr, int size) {
  int i, sum = 0;
  double avg;

  for (i = 0; i < size; ++i) {
    sum += arr[i];
  }
  avg = double(sum) / size;

  return avg;
}
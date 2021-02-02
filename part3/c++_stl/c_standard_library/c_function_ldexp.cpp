#include <stdio.h>
#include <math.h>

// 该函数返回 x * 2 ^ exp
int main(){
  double x, ret;
  int n;
  x = 0.65;
  n = 3;
  ret = ldexp(x ,n);
  printf("%f * 2^%d = %f\n", x, n, ret);

}
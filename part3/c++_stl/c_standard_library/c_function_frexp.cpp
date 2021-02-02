#include <stdio.h>
#include <math.h>

int main(){
  double x = 1024;
  double fraction;
  int e;
  fraction = frexp(x, &e);
  printf("x = %.2lf = %.2lf * 2^%d\n", x, fraction, e);
}
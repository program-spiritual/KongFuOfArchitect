#include <stdio.h>
#include <math.h>

#define PI 3.14159265

int main () {
  double x, ret, val;
  x = 1.0;
  val = 180.0 / PI;

  ret = atan (x) * val;
  printf("The arc tangent of %lf is %lf degrees", x, ret);

  return(0);
}
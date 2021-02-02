#include <stdio.h>
#include <math.h>

int main () {
  double x, ret;
  x = 0.5;

  ret = sinh(x);
  printf("The hyperbolic sine of %lf is %lf degrees", x, ret);

  return(0);
}
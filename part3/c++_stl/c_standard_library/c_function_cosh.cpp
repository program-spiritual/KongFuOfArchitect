#include <stdio.h>
#include <math.h>

int main () {
  double x;

  x = 0.5;
  printf("The hyperbolic cosine of %lf is %lf\n", x, cosh(x));

  x = 1.0;
  printf("The hyperbolic cosine of %lf is %lf\n", x, cosh(x));

  x = 1.5;
  printf("The hyperbolic cosine of %lf is %lf\n", x, cosh(x));

  return(0);
}
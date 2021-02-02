#include <stdio.h>
#include <math.h>

int main () {
  double x = 0;

  printf("The exponential value of %lf is %lf\n", x, exp(x));
  printf("The exponential value of %lf is %lf\n", x+1, exp(x+1));
  printf("The exponential value of %lf is %lf\n", x+2, exp(x+2));

  return(0);
}
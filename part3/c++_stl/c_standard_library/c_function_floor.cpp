#include <stdio.h>
#include <math.h>

int main () {
  float val1, val2, val3, val4;

  val1 = 1.6;
  val2 = 1.2;
  val3 = 2.8;
  val4 = 2.3;

  printf("Value1 = %.1lf\n", floor(val1));
  printf("Value2 = %.1lf\n", floor(val2));
  printf("Value3 = %.1lf\n", floor(val3));
  printf("Value4 = %.1lf\n", floor(val4));

  return(0);
}
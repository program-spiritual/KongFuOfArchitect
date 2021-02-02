#include <stdio.h>
#include <math.h>

#define PI 3.14159265

int main () {
  double x, y, ret, val;

  x = -7.0;
  y = 7.0;
  val = 180.0 / PI;

  ret = atan2 (y,x) * val;
  printf("The arc tangent of x = %lf, y = %lf ", x, y);
  printf("is %lf degrees\n", ret);

  return(0);
}
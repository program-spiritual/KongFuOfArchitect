#include<stdio.h>
#include<math.h>

int main () {
  double x, fractpart, intpart;

  x = 8.123456;
  fractpart = modf(x, &intpart);

  printf("Integral part = %lf\n", intpart);
  printf("Fraction Part = %lf \n", fractpart);

  return(0);
}
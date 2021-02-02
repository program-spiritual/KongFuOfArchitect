#include <stdio.h>
#include <float.h>

int main () {
  printf("The maximum value of float = %.10e\n", FLT_MAX);
  printf("The minimum value of float = %.10e\n", FLT_MIN);

  printf("The number of digits in the number = %.10d\n", FLT_MANT_DIG);
}
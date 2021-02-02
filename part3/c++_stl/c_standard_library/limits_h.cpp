#include <stdio.h>
#include <limits.h>

int main() {

  printf("The number of bits in a byte %d\n", CHAR_BIT);

  printf("The minimum value of SIGNED CHAR = %d\n", SCHAR_MIN);
  printf("The maximum value of SIGNED CHAR = %d\n", SCHAR_MAX);
  printf("The maximum value of UNSIGNED CHAR = %d\n", UCHAR_MAX);

  printf("The minimum value of SHORT INT = %d\n", SHRT_MIN);
  printf("The maximum value of SHORT INT = %d\n", SHRT_MAX);

  printf("The minimum value of INT = %d\n", INT_MIN);
  printf("The maximum value of INT = %d\n", INT_MAX);

  printf("The minimum value of CHAR = %d\n", CHAR_MIN);
  printf("The maximum value of CHAR = %d\n", CHAR_MAX);

  printf("The minimum value of LONG = %ld\n", LONG_MIN);
  printf("The maximum value of LONG = %ld\n", LONG_MAX);

  return(0);
}
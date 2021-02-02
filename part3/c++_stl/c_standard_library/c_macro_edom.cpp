#include <stdio.h>
#include <errno.h>
#include <math.h>

int main () {
  double val;

  errno = 0;
  val = sqrt(-10);

  if(errno == EDOM) {
    printf("Invalid value \n");
  } else {
    printf("Valid value\n");
  }

  errno = 0;
  val = sqrt(10);

  if(errno == EDOM) {
    printf("Invalid value\n");
  } else {
    printf("Valid value\n");
  }

  return(0);
}
#include <cmath>
#include <cstdio>

int main () {
  float a, b;
  int c;
  a = 9.2;
  b = 3.7;
  c = 2;
  printf("Remainder of %f / %d is %lf\n", a, c, fmod(a,c));
  printf("Remainder of %f / %f is %lf\n", a, b, std::fmod(a,b));

  return(0);
}
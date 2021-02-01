#include <stdio.h>
#include <ctype.h>

int main () {
  char var1[] = "tuts";
  char var2[] = "0xE";

  if( isxdigit(var1[0]) ) {
    printf("var1 = |%s| is hexadecimal character\n", var1 );
  } else {
    printf("var1 = |%s| is not hexadecimal character\n", var1 );
  }

  if( isxdigit(var2[0] )) {
    printf("var2 = |%s| is hexadecimal character\n", var2 );
  } else {
    printf("var2 = |%s| is not hexadecimal character\n", var2 );
  }

  return(0);
}
#include <stdio.h>
#include <ctype.h>

int main () {
  int var1 = 'k';
  int var2 = '8';
  int var3 = '\t';
  int var4 = ' ';

  if( isprint(var1) ) {
    printf("var1 = |%c| can be printed\n", var1 );
  } else {
    printf("var1 = |%c| can't be printed\n", var1 );
  }

  if( isprint(var2) ) {
    printf("var2 = |%c| can be printed\n", var2 );
  } else {
    printf("var2 = |%c| can't be printed\n", var2 );
  }

  if( isprint(var3) ) {
    printf("var3 = |%c| can be printed\n", var3 );
  } else {
    printf("var3 = |%c| can't be printed\n", var3 );
  }

  if( isprint(var4) ) {
    printf("var4 = |%c| can be printed\n", var4 );
  } else {
    printf("var4 = |%c| can't be printed\n", var4 );
  }

  return(0);
}   
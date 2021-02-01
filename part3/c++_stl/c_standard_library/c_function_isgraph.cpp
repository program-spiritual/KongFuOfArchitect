#include <stdio.h>
#include <ctype.h>

int main(){
  int var1 = '3';
  int var2 = 'm';
  int var3 = ' ';

  if( isgraph(var1) ) {
    printf("var1 = |%c| can be printed\n", var1 );
  } else {
    printf("var1 = |%c| can't be printed\n", var1 );
  }

  if( isgraph(var2) ) {
    printf("var2 = |%c| can be printed\n", var2 );
  } else {
    printf("var2 = |%c| can't be printed\n", var2 );
  }

  if( isgraph(var3) ) {
    printf("var3 = |%c| can be printed\n", var3 );
  } else {
    printf("var3 = |%c| can't be printed\n", var3 );
  }
}

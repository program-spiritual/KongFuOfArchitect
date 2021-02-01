#include <stdio.h>
#include <ctype.h>

int main () {
  int var1 = 't';
  int var2 = '1';
  int var3 = '/';
  int var4 = ' ';

  if( ispunct(var1) ) {
    printf("var1 = |%c| is a punctuation character\n", var1 );
  } else {
    printf("var1 = |%c| is not a punctuation character\n", var1 );
  }

  if( ispunct(var2) ) {
    printf("var2 = |%c| is a punctuation character\n", var2 );
  } else {
    printf("var2 = |%c| is not a punctuation character\n", var2 );
  }

  if( ispunct(var3) ) {
    printf("var3 = |%c| is a punctuation character\n", var3 );
  } else {
    printf("var3 = |%c| is not a punctuation character\n", var3 );
  }

  if( ispunct(var4) ) {
    printf("var4 = |%c| is a punctuation character\n", var4 );
  } else {
    printf("var4 = |%c| is not a punctuation character\n", var4 );
  }

  return(0);
}   
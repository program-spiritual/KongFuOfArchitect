#include <stdio.h>
#include <ctype.h>

int main(){
  int i = 0, j = 0;
  char str1[] = "look \a at \t your cloth";
  char str2[] = "heart \n beat";
/* Prints string till control character \a */
  while( !iscntrl(str1[i]) ) {
    putchar(str1[i]);
    i++;
  }

  /* Prints string till control character \n */
  while( !iscntrl(str2[j]) ) {
    putchar(str2[j]);
    j++;
  }
}
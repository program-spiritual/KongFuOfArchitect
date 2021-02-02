#include <stdio.h>
#include <stdlib.h>
#include <setjmp.h>
#include <iostream>
using namespace std;
void jmpfunction(jmp_buf env_buf) {
  longjmp(env_buf, 12);
}
int main(){
  int val;
  jmp_buf env_buffer;
  // save calling env for longjump;
  val = setjmp(env_buffer);
  cout << val<<endl;
  if( val != 0 ) {
    printf("Returned from a longjmp() with value = %s\n", val);
    exit(0);
  }
  printf("Jump function call\n");
  jmpfunction( env_buffer );

  return(0);
}

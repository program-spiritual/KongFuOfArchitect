#include <stddef.h>
#include <stdio.h>

int main(){
  FILE *fp;
  fp = fopen("./file.txt", "r");
  if( fp != nullptr ) {
    printf("Opend file file.txt successfully\n");
    fclose(fp);
  }
  fp = fopen("nofile.txt", "r");
  if( fp == nullptr ) {
    printf("Could not open file nofile.txt\n");
  }

}
#include <cctype>
#include <cstdio>

int main(){
  int var1 = 'd';
  int var2 = '2';
  int var3 = '\t';
  int var4 = ' ';
  if (isalnum(var1)) {   printf("var1 = |%c| is alphanumeric\n", var1 );}
  if (isalnum(var2)) {   printf("var2 = |%c| is alphanumeric\n", var2 );}
  if (isalnum(var3)) {   printf("var3 = |%c| is alphanumeric\n", var3 );}
  if (isalnum(var4)) {   printf("var4 = |%c| is alphanumeric\n", var4 );}

  if (isalpha(var1)) {   printf("var1 = |%c| is alphabet\n", var1 );}
  if (isalpha(var2)) {   printf("var2 = |%c| is alphabet\n", var2 );}
  if (isalpha(var3)) {   printf("var3 = |%c| is alphabet\n", var3 );}
  if (isalpha(var4)) {   printf("var4 = |%c| is alphabet\n", var4 );}

}
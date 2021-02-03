#include <signal.h>
#include <stdio.h>
#include <iostream>

void signal_catchfunc(int);


int main(){
  void (*ret)(int);
  ret = signal(SIGINT, signal_catchfunc);
  if( ret == SIG_ERR) {
    printf("Error: unable to set signal handler.\n");
    exit(0);
  }
  printf("Going to raise a signal\n");
  ret = reinterpret_cast<void (*)(int)>(raise(SIGINT));

  if( ret !=nullptr ) {
    printf("Error: unable to raise SIGINT signal.\n");
    exit(0);
  }
}

void signal_catchfunc(int signal){
  printf("!! signal caught");
}





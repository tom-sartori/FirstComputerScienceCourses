#include <stdio.h>
#define MESSAGE "Super\n"


int dbl(int n) {
  return n*2;
}

int main() {
  printf(MESSAGE);
  int a;
  a = dbl(4); 
  printf("Resultat : %i \n", dbl(4));
}



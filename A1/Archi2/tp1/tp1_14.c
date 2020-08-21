#include <stdio.h>
int main() {
  int t[2];
  printf("Premiere adresse: %i, seconde adresse: %i\n", (int)t, (int)(t+1));
}

#include <stdio.h>

void entier () { 
  int tab [3];
  printf ("O : %lu, 1 : %lu \n", (long unsigned) &tab[0], (long unsigned) &tab[1]);
  // Un int est donc bien sur 4 octets 
}

void flottant () {
  float tab1[3]; 
  printf ("O : %lu, 1 : %lu \n", (long unsigned) &tab1[0], (long unsigned) &tab1[1]);
  // Flottant sur 4 octets
}

int main () {
  printf("Entier : \n");
  entier();
  printf("Flottant : \n");
  flottant();
}


#include <stdio.h>

void quinze () {
  for (int i = 1; i <= 100; i++)
    printf("%i \n", i);
}  

void seize () {
  for (int i = 1; i <= 100; i++)
    if ((i % 3 != 0) && (i % 7 != 0))
      printf("%i \n", i);
}

void dixsept () {
  int test = 1;
  int x = 1;
  
  while (test == 1) {
    if ((x % 2262 == 0) && (x % 13195 == 0)) {
      test = 0;
      printf("%i \n", x);
    }
    else
      x++;
  }
}

void dixhuit () {
  char chaine[80];
  printf("Entrez une chaine: ");
  fgets(chaine, 80, stdin);
  //fputs(chaine, stdout);

  int i = 0;
  while (chaine[i] != '\0')
    i++;
  printf("Il y a %i caracteres \n", i-1);
}


int main () {
  dixhuit();
}

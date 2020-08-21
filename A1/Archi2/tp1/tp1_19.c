#include <stdio.h>

int palindrome(char *s) {

  int i = 0;

  do {
    s++;
    i++;
  }
  while (*s != '\0');
  s = s-2;
  i--;

  int j = 0;
  while (j < i-j) {
    if ((*(s +1 -i +j)) != (*(s -j)))
      return 0;
    j++;
  }
  
  return 1; 
}
  
int main () {
  char chaine[20];
  printf("Entrez une chaine : ");
  fgets(chaine, 20, stdin);
  int x = palindrome(chaine);
  printf("Resultat : %i \n", x);
}

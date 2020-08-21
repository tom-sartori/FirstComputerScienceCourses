#include <stdio.h>
int main() {
  int i;
  FILE *f;
  f = (FILE *) fopen("message.txt","r");
  while (1) {
    i = fgetc(f);
    
    i++;
    //printf ("%i", i);
    if (i == 33)
      i--;
    if (i == 123)
      i = 97; 

    
    if (feof(f)) {
      break;
    }
    fputc(i,stdout);
  }
  printf("\n");
  fclose(f);
}

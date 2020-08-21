#include <stdio.h>

#include <fcntl.h>

#include <stdlib.h>

#include <unistd.h>

#include <errno.h>

int main (int argc, char **argv) {

  if (argc != 2) {exit(1);}

  char lien [30]; 
  int i = 0; 
  
  do {
    lien[i] = argv[1][i]; 
    i++;  
  }
  while (argv[1][i] != '\0'); 
  
  
  int fd = open(lien, O_RDONLY);

  if (fd < 0) { //si probleme dans open
    if (errno == ENOENT)
      printf("Le fichier à ouvrir n'existe pas. \n");
    perror(argv[1]); 
    exit(1);
  }


  int nblus = -1;
  
  while (nblus != 0) {
    char *b = malloc (sizeof(char) *10);
    nblus = read (fd, b, 10);
    write(1, b, nblus);    

    /*
      for (int i = 0; i < 10; i++)
      printf ("%c", b[i]);
    */
  }
  printf("\n");
  close(fd); 
}

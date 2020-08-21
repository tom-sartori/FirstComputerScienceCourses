#include <stdio.h>

#include <fcntl.h>

#include <stdlib.h>

#include <unistd.h>

#include <errno.h>
int main () {
  
  int fd = open("message.txt", O_RDONLY);

  if (fd < 0) { //si probleme dans open
    if (errno == ENOENT)
      printf("Le fichier à ouvrir n'existe pas. \n");
    exit(1);
  }
  
  int nblus = -1;
  
  while (nblus != 0) {
    char *b = malloc (sizeof(char) *10);
    nblus = read (fd, b, 10); //renvois le nombre de carac  qu'il a reussi a lire
    write(1, b, nblus);    

    /*
    for (int i = 0; i < 10; i++)
      printf ("%c", b[i]);
  	*/

  }
  printf("\n");
  close(fd); 
}

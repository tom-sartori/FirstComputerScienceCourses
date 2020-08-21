#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h> // open
#include <unistd.h> // read / write


int lireLigne(int fd, char*s, int size){

  int p;
  p = lseek(fd,0,SEEK_CUR);
    int x = read(fd,s,size);
 
  int trouve=0;
  int i=0;
  
  while(i<x && !trouve){
    trouve = s[i]=='\n';
    i++;
  }

  if(trouve){
    lseek(fd,p+i,SEEK_SET); //le \n était en p+i-1 donc on remet la tete en p+i 
    return i;
  }
  else{
    return x;
  }
}


int main (int argc, char **argv) {
	if (argc != 4) {printf("Erreur argument. \n"); exit(1); }

	int fdd = open (argv[1], O_RDONLY); 
	if (fdd < 0) {perror(argv[1]); exit(1);}

	int fda = open (argv[2], O_CREAT | O_WRONLY, 0640); 
	int nblus; 

	for (int i = 0; i < 3; i++) {
		char *s = malloc(sizeof(char) * 10); 
		nblus = lireLigne(fdd, s, 10); 
		write(fda, s, nblus); 
	}
	/*
	i = 0; 
	char chiffre [3]; 
	do {
		chiffre[i] = argv[3][i]; 
		i++; 
	} 
	while (argv[3][i] != '\0'); 
*/

	printf("%c \n", argv[3][0]);

	int x = atoi(argv[3]); 
	printf("i : %i \n", x);

	nblus = -1; 
	while (nblus != 0) {
		char *s = malloc(sizeof(char) * 4096); 
		nblus = read(fdd, s, 4096); 

		for (int j = 0; j < nblus; j++) {
			if ((int)s[j] + x > 255)
				s[j] = 255; 
			else 
				s[j] = (int)s[j] + x; 
		}
		write(fda, s, nblus); 
	}
}

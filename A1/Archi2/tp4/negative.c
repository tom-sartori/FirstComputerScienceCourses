#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>

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


int main (int argc, char ** argv) {

	if (argc != 3) {printf("Manque d'arguments\n"); exit(1);}


	int fdd = open(argv[1],O_RDONLY); 
	if (fdd < 0) {perror(argv[1]); exit(1);}

	int fda = open(argv[2], O_CREAT | O_WRONLY, 0644); 


	int nblus; 

	for (int j = 0; j < 3; j++) {
		char *s = malloc(sizeof(char) *100);
		nblus = lireLigne(fdd, s, 11);
		write(fda, s, nblus); 
	}
	nblus = -1; 

	while(nblus != 0) {
		char *s = malloc(sizeof(char) *1000); 
		nblus = read(fdd, s, 1000); 
		for (int k = 0; k < nblus; k++) {
			s[k] = 255 - (int)(s[k]); 
		}
		write(fda, s, 1000);
	}



}
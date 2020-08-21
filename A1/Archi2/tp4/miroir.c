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

	if (argc != 4) {printf("Erreur Argument. \n"); exit(1);}

	int fdd = open(argv[1], O_RDONLY); 
	if (fdd < 0) {perror(argv[1]); exit(1);}

	int fda = open (argv[2], O_CREAT | O_WRONLY, 0640); 

	//verticale 

	int largeur; 
	int nblus; 
	char taille [4]; 
	for (int i = 0; i < 3; i++) {
		char *s = malloc(sizeof(char) *10);  
		nblus = lireLigne(fdd, s, 10); 
		write(fda, s, nblus);
		if (i == 1) {
			largeur = atoi(s); 
		}
	}
	printf("largeur %d\n",largeur);
	nblus = -1; 
	while (nblus != 0) {
		char *s = malloc(sizeof(char) * largeur*3/2); 
		nblus = read(fdd, s, largeur*3/2); 
		write(fda, s, nblus); 
		char *inverse = malloc(sizeof(char) * nblus); 
		for (int j = 0; j < nblus; j = j+3)
			for (int k = 3; k > 0; k--) 
				inverse[j +3 -k] = s[nblus -j -k]; 
		write(fda, inverse, nblus); 
		nblus = read(fdd, s, largeur*3/2); 
		//lseek(fdd, SEEK_CUR, largeur*3/2);
	}
}

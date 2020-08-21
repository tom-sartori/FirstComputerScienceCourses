#include <stdlib.h>
#include <stdio.h>

#include <fcntl.h> // open

#include <unistd.h>// read / write

int main (int argc, char **argv) {

/*
	printf("argc : %i \n", argc);

	for (int i = 0; i < 20; i++)
		printf("%c \n", argv[1][i]);

*/

	if (argc != 3) { exit(1);}

	char lien1 [30], lien2 [30]; 
	int j = 0; 

	do {
		lien1[j] = argv[1][j]; 
		j++; 
	}
	while (argv[1][j] != '\0'); 

	j = 0; 
	do {
		lien2[j] = argv[2][j]; 
		j++; 
	}
	while (argv[1][j] != '\0'); 


	int fdd = open(lien1, O_RDONLY); 
	if (fdd < 0) {perror(argv[1]); exit(1);}

	int fda = open(lien2, O_CREAT | O_WRONLY, 0777); 
	// if (fda < 0) {perror(argv[2]); exit(1);}

	int nblus = -1; 

	while (nblus != 0) {
		char *b = malloc (sizeof(char) *10);
		nblus = read(fdd, b, 10); 
		int nb = write(fda, b, nblus);
		printf("nb ecrits %d\n",nb); 
	}
}

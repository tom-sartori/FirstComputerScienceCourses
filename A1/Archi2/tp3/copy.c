#include <stdlib.h>
#include <stdio.h>

#include <fcntl.h> // open

#include <unistd.h>// read / write

int main () {
	int fdd = open("message.txt", O_RDONLY); 
	int fda = open("copie.txt", O_CREAT | O_WRONLY, 0777); 
	int nblus = -1; 

	while (nblus != 0) {
		char *b = malloc (sizeof(char) *10);
		nblus = read(fdd, b, 10); 
		int nb = write(fda, b, nblus);
		printf("nb ecrits %d\n",nb); 
	}
}
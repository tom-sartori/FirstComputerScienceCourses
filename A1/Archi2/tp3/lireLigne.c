#include <stdio.h>
#include <stdlib.h>

#include <fcntl.h> // open

#include <unistd.h>// read / write


int lireLigne (int fd, char *s, int size) {
	int nblus = -1; 
	int i;  
	int lus = 0; 
	int stop = 0; 

	while (nblus != 0 && stop == 0) {
		char c [10];
		nblus = read(fd, c, 10); 
		printf("nblus : %i \n", nblus);
		i = 0; 
		while (lus < size && i < nblus && stop ==0) {
			if (c[i] != '\n') {
				s[lus] = c[i]; 
				lus++; 
				i++; 
			}
			else {
				s[lus] = c[i];
				lus++;  
				stop = 1; 
			}
		}
	}
	lseek(fd, lus, SEEK_SET); 
	return lus; 
}



int main () {
	int fd = open("message.txt", O_RDONLY); 
	char *s = malloc (sizeof(char) *1000); 

/*
	int fd2 = open("input.txt", O_RDWR| O_CREAT, 0644); 
	char c[2];
	c[0]='a';
	c[1]='b';
	write(fd2,c,2);
	close(fd2);

	fd2 = open("input.txt", O_RDONLY); 
	int nblus = read(fd2, c, 10); 
	printf("nblus dans main : %i \n", nblus);
*/

	for (int j = 0; j < 2; j++) {
		int x = lireLigne(fd, s, 5); 

		printf("x : %i\n", x);


		for (int i = 0; i < 50; i++)
			printf("%c", s[i]); 
		printf("\n");
	}

}

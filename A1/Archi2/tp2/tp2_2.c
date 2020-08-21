#include <stdio.h>
#include <stdlib.h>

int* copie(int *tab, int n) {
	int *tab2 = malloc(sizeof(int) *n);
	for (int i = 0; i < n; i++) {
		tab2[i] = tab[i];
	}
	return tab2;
}

int* unsurdeux (int *tab, int n) {
	int *tabbis = malloc(sizeof(int) *((n/2) +1)); 

	for (int i = 0; i < n; i++) {
		tabbis[i] = tab[2*i]; 
		//printf("t : %i\n", tabbis[i] );
	}
	return tabbis; 
}


int main () {
	int n = 5; 
	int tab [5] = {1, 5, -1, 7, 24}; 
	int * t = copie(tab, n); 
	for (int i = 0 ; i < 10; i++) 
		printf("%i ", t[i]);	
	//unsurdeux(tab, n); 
}

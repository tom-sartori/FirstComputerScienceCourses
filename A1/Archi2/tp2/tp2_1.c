#include <stdio.h>

int maximum (int *t, int n) {
	int x = *t;

	for (int i = 0; i < n; i++)
		if (x < *(t+i))
			x = *(t+i); 

		return x; 
	}


// Tri a bulle de tout le tableau 
	int maximumbis (int *t, int n) {
		int a=0, b=0;
		do {
			for(int i = n -1; i >= 0; i--) {
				if(t[i] > t[i+1]) {
					a = t[i];
					t[i] = t[i+1];
					t[i+1] = a;
				}
			}
			b++;
		}
		while(b!=n);

		return ("Res : %i \n", *(t+n-1)); 
	}

	void minmax(int *t, int n, int *pmin, int *pmax) {

		int min = *t, max = *t;  

		for (int i = 0; i < n; i++) {
			if (min > *(t +i)) 
				min = *(t +i); 
			if (max < *(t +i))
				max = *(t+i);
		}
		*pmin = min; 
		*pmax = max; 
	}

	void minmaxbis(int *t, int n, int *pmin, int *pmax) {

		for (int i = 0; i < n; i++) {
			if (*pmin > *(t +i)) 
				*pmin = *(t +i); 
			if (*pmax < *(t +i))
				*pmax = *(t+i);
			}
		}


	int main ()  {
		int n = 10; 
		int tab [10] = {1, -7, 50, -4, 0, 100, -60, 11, 5, -4}; 
		//printf("max : %i \n", maximum(tab, n)); 
		int min = tab[0], max = tab[0]; 

		minmaxbis(tab, n, &min, &max); 
		printf ("min : %i / max : %i \n", min, max);
	}

#include <stdio.h>
#include <stdlib.h>

struct Matrice {
  int nLignes; 
  int nColonnes; 
  int **valeurs; 
};


void affiche (struct Matrice m) {
  for (int i = 0; i < m.nLignes; i++) {
    for (int j = 0; j < m.nColonnes; j++)
      printf("%3i", m.valeurs[i][j]);
    printf("\n");
  }
}
// question 2
struct Matrice matrice (int nbl, int nbc, int *valeurs) { //pas oublier malloc
  int index = 0; 
  int **tab = malloc (nbl * sizeof(int*)); 
  for (int i = 0; i < nbl; i++) {
    int *tab1 = malloc (nbc * sizeof(int)); 
    for (int j = 0; j < nbc; j++) {
      tab1[j] = valeurs[index]; 
      index++;
    }
    tab[i] = tab1;  
  }
  struct Matrice m = {
    m.nLignes = nbl,
    m.nColonnes = nbc,
    m.valeurs = tab,
  };
  return m; 
}

int main () {	
  int l1[3] = {1, 2, 3};
  int l2[3] = {4, 5, 6};
  int *v[2] = {l1, l2};
  struct Matrice m = {
    m.nLignes = 2,
    m.nColonnes = 3,
    m.valeurs = v,
  };
  affiche(m);


  int mat[6] = {1, 2, 3, 4, 5, 6};
  struct Matrice mat1 = matrice (2, 3, mat);
  afficher (mat1); 
	
}

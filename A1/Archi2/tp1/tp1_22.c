#include<stdio.h>
/*
int age_total (struct Famille) {

  return 0; 
}*/

int main () {
  struct Personne {
    char *nom;
    int age;
    float taille;
  };

  struct Famille {
    char *nom;
    char *pere;
    char *mere;
    int nb_enfants;
    struct Personne enfants [];
  }; 

  printf("chaine: %i, entier: %i, flottant: %i, personne: %i, famille: %i\n", sizeof(char*), sizeof(int), sizeof(float), sizeof(struct Personne), sizeof(struct Famille));


  struct Personne p1;
  char nom1[] = "Guybrush"; 
  p1.nom = nom1;
  p1.age = 22;
  p1.taille = 1.75;

  struct Personne p2; 
  char nom2[] = "Jean"; 
  p2.nom = nom2;
  p2.age = 32;
  p2.taille = 1.50;

  struct Personne p3; 
  char nom3[] = "Jacky"; 
  p3.nom = nom3;
  p3.age = 12;
  p3.taille = 1.51;

  struct Personne p4; 
  char nom4[] = "Jean"; 
  p4.nom = nom4;
  p4.age = 13;
  p4.taille = 1.20;  

  struct Famille f1; 
  char nom5 [] = "Dupont"; 
  f1.nom = nom5; 
  f1.pere = p2.nom; 
  f1.mere = p1.nom; 
  f1.nb_enfants = 2; 
  struct Personne enfants [f1.nb_enfants] = {p3, p4}; 
  f1.enfants = enfants; 


  printf("ppp : %lu\n", p1);
  printf("pno : %lu / %c \n", (p1.nom), *(p1.nom));
  printf("age : %lu / %i \n", &(p1.age), (p1.age) );
  printf("tai : %lu / %f \n", &(p1.taille), (p1.taille));

}


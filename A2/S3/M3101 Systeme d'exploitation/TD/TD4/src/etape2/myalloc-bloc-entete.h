#include <stdlib.h>
/*
 * Gestion des blocs avec une liste chainee
 */
typedef struct bloc_entete
{
  size_t taille; //taille du bloc utilisateur
  struct bloc_entete* suivant_ptr ;    // pointeur sur le bloc suivant dans la liste
  struct bloc_entete* precedent_ptr ;    // pointeur sur le bloc precedent dans la liste
  
} bloc_entete ;

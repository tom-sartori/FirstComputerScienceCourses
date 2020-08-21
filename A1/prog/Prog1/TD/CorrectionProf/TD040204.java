import java.util.Arrays;

public class CorrectionTD040204 {
    public static int[][] matSpirale(int n){ // fonction matSpirale(n : entier) retourne tableau de n*n entiers
        // Variables
        int[][] matA = new int[n][n];                                           // matA : tableau de n*n entiers
        int ligneDepart, ligneArrivee, colonneDepart, colonneArrivee, compteur; // ligneDepart,ligneArrivee,colonneDepart,colonneArrivee,compteur : entiers
        // Début
        ligneDepart = 0;                                                        // ligneDepart = 0;
        ligneArrivee = n-1;                                                     // ligneArrivee = n-1;
        colonneDepart = 0;                                                      // colonneDepart = 0;
        colonneArrivee = n-1;                                                   // colonneArrivee = n-1;
        compteur = 1;                                                           // compteur = 1;
        while(ligneDepart<=ligneArrivee && colonneDepart<=colonneArrivee){      // tantQue ligneDepart<=ligneArrivee et colonneDepart<=colonneArrivee
            for(int i=colonneDepart;i<=colonneArrivee;i++){                     //      pour i dans colonneDepart..colonneArrivee faire
                matA[ligneDepart][i] = compteur;                                //          matA[ligneDepart][i] = compteur;
                compteur++;                                                     //          compteur=compteur+1;
            }                                                                   //      finPour
            ligneDepart++;                                                      //      ligneDepart=ligneDepart+1;
            for(int i=ligneDepart;i<=ligneArrivee;i++){                         //      pour i dans ligneDepart..ligneArrivee faire
                matA[i][colonneArrivee] = compteur;                             //          matA[i][colonneArrivee] = compteur;
                compteur++;                                                     //          compteur=compteur+1;
            }                                                                   //      finPour
            colonneArrivee--;                                                   //      colonneArrivee=colonneArrivee-1;
            for(int i=colonneArrivee;i>=colonneDepart;i--){                     //      pour i dans colonneArrivee..colonneDepart faire
                matA[ligneArrivee][i] = compteur;                               //          matA[ligneArrivee][i] = compteur;
                compteur++;                                                     //          compteur=compteur+1;
            }                                                                   //      finPour
            ligneArrivee--;                                                     //      ligneArrivee=ligneArrivee-1;
            for(int i=ligneArrivee;i>=ligneDepart;i--){                         //      pour i dans ligneeArrivee..ligneDepart faire
                matA[i][colonneDepart] = compteur;                              //          matA[i][colonneDepart] = compteur;
                compteur++;                                                     //          compteur=compteur+1;
            }                                                                   //      finPour
            colonneDepart++;                                                    //      colonneDepart=colonneDepart+1;
        }                                                                       // finTantQue
        return matA;                                                            // return matA;
        // Fin matSpirale
    }
    // Procédure principale pour tester votre fonction
    public static void main(String args[]) {
      int n = 4; // Essayer plusieurs entrées différentes pour tester votre fonction
      int[][] matA = matSpirale(n);
      for(int i=0;i<n;i++){
        System.out.println(Arrays.toString(matA[i]));
      }
    }
}

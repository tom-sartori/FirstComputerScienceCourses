import java.util.Arrays;

public class CorrectionTD040203bis {
    public static int[][] matDiagonale(int n){ // fonction matDiagonale(n : entier) retourne tableau de n*n entiers
        // Variables
        int[][] matA = new int[n][n];   // matA : tableau de n*n entiers
        int cpt,i,j,retourI,retourJ;    // cpt, i, j, retourI, retourJ : entiers
        // Début        
        cpt = 1;                        // cpt = 1;
        i = 0;                          // i = 0;
        j = 0;                          // j = 0;
        retourI = 1;                    // retourI = 1;
        retourJ = 0;                    // retourJ = 0;
        while(i+j<n){                   // tantQue i+j<n faire
            matA[i][j]=cpt;             //      matA[i][j]=cpt;
            cpt++;                      //      cpt=cpt+1;
            j++;                        //      j=j+1;
            i--;                        //      i=i-1;
            if(i<0 || j>=n){            //      si i<0 ou j>=n alors
                i=retourI;              //          i=retourI;
                j=retourJ;              //          j=retourJ;
                retourI++;              //          retourI=retourI+1;
            }                           //      finSi
        }                               // finTantQue
        i = n-1;                        // i = n-1;
        j = 1;                          // j = 1;
        retourI = n-1;                  // retourI = n-1;
        retourJ = 2;                    // retourJ = 2;
        while(cpt<=n*n){                // tantQue cpt<=n²
            matA[i][j]=cpt;             //      matA[i][j]=cpt;
            cpt++;                      //      cpt=cpt+1;
            j++;                        //      j = j+1;
            i--;                        //      i = i-1;
            if(i<0 || j>=n){            //      si i<0 ou j>=n alors
                i=retourI;              //          i = retourI;
                j=retourJ;              //          j = retourJ;
                retourJ++;              //          retourJ=retourJ+1;
            }                           //      finSi
        }                               // finTantQue
        return matA;                    // return matA;
        // Fin matDiagonale
    }
    // Procédure principale pour tester votre fonction
    public static void main(String args[]) {
      int n = 5; // Essayer plusieurs entrées différentes pour tester votre fonction
      int[][] matA = matDiagonale(n);
      for(int i=0;i<n;i++){
        System.out.println(Arrays.toString(matA[i]));
      }
    }
}

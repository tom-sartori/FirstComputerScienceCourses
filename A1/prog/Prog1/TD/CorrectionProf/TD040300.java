import java.util.Arrays;

public class UsernameTD040300 {
    public static int[][] carreMagique(int n){ // fonction carreMagique(n : entier) retourne tableau de n*n entiers
        <...>
    }
    public static boolean estCarreMagique(int[][] matA, int n){
        int sum1=Arrays.stream(matA[0]).sum(), i=0, sum2;
        while(i<n){
            if(sum1!=Arrays.stream(matA[i]).sum()){
                return false;
            }
            i++;    
        }
        i=0;
        while(i<n){
            sum2=0;
            for(int j=0;j<n;j++){
                sum2+=matA[j][i];
            }
            if(sum1!=sum2){
                return false;
            }
            i++;
        }
        sum2=0;
        for(int j=0;j<n;j++){
            sum2+=matA[j][j];
        }
        if(sum1!=sum2){
                return false;
        }
        sum2=0;
        for(int j=0;j<n;j++){
            sum2+=matA[j][n-1-j];
        }
        if(sum1!=sum2){
                return false;
        }
        return true;
    }
    // Procédure principale pour tester votre fonction
    public static void main(String args[]) {
      int n = 3; // Essayer plusieurs entrées différentes pour tester votre fonction
      int[][] matA = carreMagique(n);
      for(int i=0;i<n;i++){
        System.out.print(Arrays.toString(matA[i]));
        if(i!=n/2){
            System.out.println("");
        }
        else{
            if(estCarreMagique(matA,n)){
                System.out.println(" est un carre magique.");    
            }
            else{
                System.out.println(" n'est pas un carre magique.");
            }
        }
      }
    }
}

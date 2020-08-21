public class CheminCarre {

    public static void main (String args[]) {

	Ut.afficher ("n = ");
	int n = Ut.saisirEntier();

	int [][] mat = new int [n] [n];

	int x = 0;
	int y = 0; 

	    for (int i = 0; i < n; i++) {  
		mat [0][i] = 1;
		mat [i] [0] = 1;
	    }
	    for (int i = 1; i < n; i++) 
		for (int j = 1; j < n; j++) 
		    mat[i][j] = mat[i-1][j] + mat[i][j-1]; 

	Utt.AfficheMatrice(mat);

	Ut.afficher(mat[n-1][n-1] + " chemins pour ce carré \n");  
    }
}



import java.util.*;
import java.lang.*;

public class Utt  {

       public static int[][] DemandeMatrice () {
	int n, m, i, j;

	Ut.afficher("Nb lignes : ");
	n = Ut.saisirEntier();
	Ut.afficher("Nb colones : ");
	m = Ut.saisirEntier();

	int mat[][];
	mat = new int [n][m];
	Ut.afficher("Saisir votre matrice : ");

	for (i=0; i<n; i++) {
	    for (j=0; j<m; j++) {
		mat[i][j] = Ut.saisirEntier();
	    }
	}
	return(mat);
       }

    
    public static void AfficheMatriceAncien (int [][]mat) {
	int n, m, i, j;
	
	n = mat.length;
	m = mat[0].length;
	    
	for (i=0; i<n; i++) {
	    for (j=0; j<m; j++) {
		Ut.afficher(mat[i][j] + "  ");
		    }
	    Ut.afficher("\n");
	}
    }

    public static void AfficheMatrice (int [][]mat) {
	int n, m, i, j, max;
	
	n = mat.length;
	m = mat[0].length;

	i = 0;
	j = 0;
	max = 1;

	while ((i < n) & (max < 3)) {
	    j = 0;
	    while ((j < m) & (max < 3)) {
		if ((mat[i][j] /10 > 0) & (max < 2))
		    max = 2;
		if ((mat[i][j] /100 > 0) & (max < 3))
		    max = 3;
		j = j+1;
	    }
	    i = i+1;
	}
	    
	for (i=0; i<n; i++) {
	    for (j=0; j<m; j++) {		
		if (max == 2) {
		    if (mat[i][j] /10 == 0)
			Ut.afficher(' ');
		}
		    
		if (max == 3) {
		    if (mat[i][j] /100 == 0) {
			Ut.afficher(' ');
			if (mat[i][j] /10 == 0)
			    Ut.afficher(' ');
		    }
		}
	    
		Ut.afficher(mat[i][j] + "  ");
		    }
	    Ut.afficher("\n");
	}
    }
    
} // end class

public class TD04{
    public static void main (String[]args) {

	int x;
	int [][]mat1;
	int [][]mat2;

	Ut.afficher("Exo numero : ");
	x = Ut.saisirEntier();

	if (x == 14) {

	    mat1 = Ut.DemandeMatrice();
	    mat2 = Ut.DemandeMatrice();
		
	    Ut.AfficheMatrice(Produit(mat1, mat2));
	}

	if (x==21) {
	    int n;
	    Ut.afficher("n = ");
	    n = Ut.saisirEntier();
	    Ut.AfficheMatrice(Range(n));
	}
	
	if (x==22) {
	    int n;
	    Ut.afficher("n = ");
	    n = Ut.saisirEntier();
	    Ut.AfficheMatrice(Serpentin(n));
	}

	if (x==23) {
	    int n;
	    Ut.afficher("n = ");
	    n = Ut.saisirEntier();
	    Ut.AfficheMatrice(Diagonale(n));
	}

	if (x==24) {
	    int n;
	    Ut.afficher("n = ");
	    n = Ut.saisirEntier();
	    Ut.AfficheMatrice(Spirale(n));
	   
	}
	if (x == 3) {
	    int n;
	    Ut.afficher("n = ");
	    n = Ut.saisirEntier();
	    Ut.AfficheMatrice(CarreM(n));
	}
    }

	public static int [][] Produit (int [][]mat1, int [][]mat2) {
	    int i, j, k, m, n, o;

	    n = mat1.length;
	    m = mat1[0].length;
	    o = mat2[0].length;
	    
	    int [][] mat;
	    mat = new int [n][o];

	    for (i=0; i<n; i++) {
		for (j=0; j<o; j++) {
		    for (k=0; k<m; k++) {
			mat[i][j] = (mat[i][j] + (mat1[i][k] * mat2[k][j]));
		    }
		}
	    }
	    return(mat);
	}
    
	public static int[][] Range (int n) {
	    int  i, j, x;
	    int [][]mat;
	    mat = new int [n][n];
	    x = 0;

	    for (i=0; i<n; i++) {
		for (j=0; j<n; j++) {
		    x = x+1;
		    mat[i][j] = x;
		}}
	    return(mat);
	    
	}

    public static int [][] Serpentin (int n) {
	int i, j, x;
	int [][]mat;
	mat = new int [n][n];
	x = 0;
	for (i=0; i<n; i++) {
	    for (j=0; j<n; j++) {
		x = x+1;
		if (i%2 == 0) 
		    mat[i][j] = x;
		else 
		    mat[i][j] = x+n-1-j*2;
	    }}
	return (mat);
    }
    
    public static int [][] Diagonale (int n) {
	int i, j, x;
	int [][]mat;
	mat = new int [n][n];
	x = 0;
	for (i=0; i<n; i++) {
	    for (j=0; j<n; j++) {

		
	    }}
	return (mat);	
    }

	public static int [][] Spirale (int n) {
	    int i, j, x;
	    int [][]mat;
	    mat = new int [n][n];
	    x = 0;
	    
	    for (i=0; i<n; i++) {
		for (j=0; j<n; j++) {
		    
		    if (i == 0) ///premiere ligne
			mat[i][j] = j+1;
		    
		    if (i == 1 & j < (n-1)) /// deuxieme ligne
			mat[i][j] = 4*(n-1)-i+1+j;
		    
		    if (j == (n-1)) /// derniere colone
			mat[i][j] = n+i;
			
		    if (j == 0 & i >1) /// premiere colone
			mat[i][j] = 4*(n-1)-i+1+j;

		    if (i < (n/2) & j > 0)
			mat[i][j] = (mat[i][j-1] *2)-6; 

		    if (i == (n-1) & j > 0) /// derniere ligne
			mat[i][j] = mat[i][j-1] -1;
		    
		    
		}}
	    return(mat);
	    }

    public static int [][] CarreM (int n) {
	int x, y, oldX, oldY, val;
	int [][]mat;
	mat = new int [n][n];

	val = 1;
	x = (n-1)/2;
	y = 0;

	mat [0][(n-1)/2] = 1;

	while (val < (n*n)) {
	    oldX = x;
	    oldY = y;
	    
	    if (y-1 < 0)
		y = n-1;
	    else
		y = y-1;

	    if (x+1 > n-1) 
		x = 0;
	    else
		x = x+1;

	    if (mat[y][x] != 0) {
		x = oldX;
		y = oldY + 1;
	    }

	    val = val+1;
	    mat[y][x] = val;
	    
	}
	return(mat);
    }

    
}
	    
		   
		

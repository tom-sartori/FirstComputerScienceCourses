
import java.util.*;
import java.lang.*;

public class Ut {

    public static void afficher (String ch) {
	System.out.print(ch);
    }

    public static void afficherSL (String ch) {
	System.out.println(ch);
    }

    public static void afficher (int nb) {
	System.out.print(nb + "");
    }

    public static void afficherSL (int nb) {
	System.out.println(nb + "");
    }

    /** Retour a la ligne */
    public static void passerLigne () {
	System.out.println("");
    }

    public static void passerALaLigne () {
	System.out.println("");
    }

    public static void sauterALaLigne () {
	System.out.println("");
    }

    public static void afficher (double nb) {
	System.out.print(nb + "");
    }

    public static void afficherSL (double nb) {
	System.out.println(nb + "");
    }

       public static void afficher (float nb) {
	System.out.print(nb + "");
    }

    public static void afficherSL (float nb) {
	System.out.println(nb + "");
    }

    public static void afficher (char c) {
	System.out.print(c + "");
    }

    public static void afficherSL (char c) {
	System.out.println(c + "");
    }

   public static void afficher (boolean b) {
	System.out.print(b + "");
    }

    public static void afficherSL (boolean b) {
	System.out.println(b + "");
    }

    public static int saisirEntier () {
	
	Scanner clavier=new Scanner(System.in);
	String s = clavier.nextLine(); //int lu = clavier.nextInt();
	int lu=456;
	try{
	    lu = Integer.parseInt(s);
	}
	catch(NumberFormatException ex){
	    System.out.println("Ce n'est pas un entier valide");
	}
	return lu;
    }

    public static double saisirReel () {
	
	Scanner clavier=new Scanner(System.in);
	String s = clavier.nextLine();
	double lu = -123.987;
	try{
	    lu = Double.parseDouble(s);
	}
	catch(NumberFormatException ex){
	    System.out.println("Ce n'est pas un reel valide");
	}
        return lu;
    }

    public static float saisirFlottant () {
	
	Scanner clavier=new Scanner(System.in);
	String s = clavier.nextLine();
	float lu = -123.987F;
	try{
	    lu = Float.parseFloat(s);
	}
	catch(NumberFormatException ex){
	    System.out.println("Ce n'est pas un reel valide");
	}
        return lu;
    }

    public static char saisirCaractere () {
	
	Scanner clavier=new Scanner(System.in);
	char lu = clavier.next().charAt(0);
        return lu;
    }

    public static boolean saisirBooleen () {
	
	Scanner clavier=new Scanner(System.in);
	boolean lu = clavier.nextBoolean();
        return lu;
    }

    public static int alphaToIndex (char c) {
	// Prerequis : c est un caractere entre 'a' et 'z'
	// Resultat : la valeur 0 pour 'a', 12 pour 'm', 25 pour 'z'...
	return (int)c - 97;
    }

    public static char indexToAlpha (int i) {
	// Prerequis : i est un entier entre 0 et 25 
	//             (par exemple, indice d'un tableau)
	// Resultat : la valeur 'a' pour 0, 'm' pour 12, 'z' pour 25...
	return (char)(i + 97);
    }

    /**
     * @param a entier
     * @param b entier
     * Pre-requis : aucun
     * @return le PGCD de a et b en utilisant l'algorithme d'Euclide
     */
    public static int pgcd(int a, int b) {

	a=Math.abs(a);
	b=Math.abs(b);
	int temp;
	while (b != 0) {
	    temp = b;
	    b = a%b;
	    a = temp;
	}
	return a;
    } 

    public static int randomMinMax(int min, int max) {
	// Resultat : un entier entre min et max choisi aleatoirement
	Random rand = new Random();
	int res = rand.nextInt(max - min + 1) + min;
	//System.out.println(res + " in [" + min + "," + max + "]");
	assert min <= res && res <= max : "tirage aleatoire hors des bornes";
	return res;
    }

    public static void clearConsole () {
	// Action : efface la console (le terminal)
	System.out.print("\033[H\033[2J");
    }

    public static void pause (int timeMilli) {
	// Action : suspend le processus courant pendant timeMilli millisecondes
	try {
	    Thread.sleep(timeMilli); 
	} catch(InterruptedException ex) {
	    ex.printStackTrace();
	}
    }

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




	

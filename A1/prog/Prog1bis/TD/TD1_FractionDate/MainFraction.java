
import java.util.Scanner; 
import java.lang.*;

class MainFraction { // Classe de test de Fraction et contenant la fonction principale

    public static void main(String args[]){
	
	Fraction f1, f2, f3, f4; // declaration de 4 variables/instances de type/classe Fraction

	f1 = new Fraction(-4,5); // fabrication d'une instance de la classe Fraction à l'aide du constructeur a deux arguments entiers

	f2 = new Fraction(13,26); // fabrication d'une instance de la classe Fraction à l'aide du constructeur a deux arguments entiers

	f3 = new Fraction("24/36"); // fabrication d'une instance de la classe Fraction à partir d'une chaîne de caractères

	f4 = new Fraction(f2); // fabrication d'une instance de la classe Fraction par recopie de l'instance f2

	System.out.print ("f1 = "); System.out.println (f1.toString());
	System.out.println ("f2 = " + f2.toString()); 
	System.out.println ("f3 = " + f3.toString());
	System.out.println ("f4 = " + f4); // f4 n'etant pas de type String, f4.toString() est invoquee automatiquement : le resultat est concatene a la chaine precedente ("f4 = ")

	/* A COMPLETER A PARTIR D'ICI !! */

	/* 
	// reduire 
	f2.reduire();
	System.out.println ("f2 = " + f2.toString());
	*/
	
	// reduire sans changement de this
	System.out.println ("f3 reduit = " + f3.fractionReduite().toString() + " | f3 = " + f3);

	//this * f sans changement de this
	System.out.print ("f1 * f2 = " + f1.fractionMultiplication(f2).toString());
	System.out.println (" | f1 * f2 reduit = " + f1.fractionMultiplication(f2).fractionReduite().toString());

	//addition this + f
	System.out.print ("f1 + f2 = " + f1.fractionAddition(f2).toString());
	System.out.println (" | f1 + f2 reduit = " + f1.fractionAddition(f2).fractionReduite().toString());

	//this ^n
	System.out.print ("f1 ^4 = " + f1.fractionPuissance(4).toString());
	System.out.println (" | f1 ^4 reduit = " + f1.fractionPuissance(4).fractionReduite().toString());
    }
}


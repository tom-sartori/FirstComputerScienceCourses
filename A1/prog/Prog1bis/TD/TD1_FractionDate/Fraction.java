
import java.util.Scanner; 
import java.lang.*;

public class Fraction {

    private int numerateur;

    private int denominateur; // Invariant : different de 0

    public Fraction (int num, int denom) {
	/*  Action : constructeur a partir de deux entiers.
	 *  Pre-requis : denom est different de 0 !
	 */
	this.numerateur = num;
	this.denominateur = denom;
    }

    public Fraction (Fraction frac) { // constructeur par recopie frac --> this
	this.numerateur = frac.numerateur;
	this.denominateur = frac.denominateur;
	// Rmq : peut s'écrire en faisant appel au constructeur precedent : this(frac.numerateur, frac.denominateur);
    }

    public Fraction (String strFrac) {
	/* Action : constructeur a partir d'une chaine de caracteres. 
	   Pre-requis : strFrac est une chaine de caracteres correspondant a une fraction, par exemple "13/26" 

	   Remarque pedagogique : parseInt est une methode de classe (Integer) ;
	   split est une methode d'instance (strFrac) 
	*/
	String str[];   // declaration d'un tableau de chaines de caracteres
        str = strFrac.split("/");  // Appel de la methode 'split' d'un objet de classe String : eclatement de strFrac en plusieurs sous-chaines separees par des '/' et rangees
	                           // dans str. Exemple : si strFrac=="13/26", alors str[0] vaut "13" et str[1] vaut "26". 
	this.numerateur = Integer.parseInt(str[0]);    // La methode de la classe Integer permet de traduire la chaine en argument en Integer... 
                                                       // Java sait automatiquement transformer (on dit "caster" ou "faire un cast" - anglicisme) une valeur Integer vers int.
	this.denominateur = Integer.parseInt(str[1]);
    }


    // public void affiche() {
    // !! Mieux vaut utiliser toString() ci-apres !!
    //	System.out.println("Fraction = " + this.numerateur + " / " + this.denominateur);
    // }

    public String toString() {
      return this.numerateur + "/" + this.denominateur; 
    }

    /* A COMPLETER A PARTIR D'ICI !! */

    public void reduire() {
	int x;
	x = Ut.pgcd(this.numerateur, this.denominateur);
	this.numerateur = this.numerateur / x;
	this.denominateur = this.denominateur / x;
    }

    public Fraction fractionReduite() {
	int x; 
	x = Ut.pgcd(this.numerateur, this.denominateur);

	return new Fraction (this.numerateur/x,  this.denominateur/x);
    }

    public Fraction fractionMultiplication(Fraction f) { //renvoit une nouvelle fraction qui vaut this * f
	
	return new Fraction (this.numerateur * f.numerateur, this.denominateur * f.denominateur);	
    }

    public Fraction fractionAddition(Fraction f) {
	int x;
	x = Ut.pgcd(this.denominateur, f.denominateur);
	return new Fraction (this.numerateur * x + f.numerateur * x, this.denominateur * x + f.denominateur * x);
    }

    public Fraction fractionPuissance(double n) {

	return new Fraction ((int)Math.pow(this.numerateur, n), (int)Math.pow(this.denominateur, n));
	
    }
}

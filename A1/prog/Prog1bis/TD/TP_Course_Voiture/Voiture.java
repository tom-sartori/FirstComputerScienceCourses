public class Voiture {

    private String unNom;
    private int uneVitesse;
    private int position;
    private int sens;

    Compte[] tableau ;

    tableau = new Compte[2];
    tableau[0] = new Compte(voit1, 5);
    tableau[1] = new Compte(voit2, 6);

    public Voiture(String unNom, int uneVitesse) { 
	/* pré-requis : 0 <= position   et   sens == 1 ou -1
	 * action : crée une voiture de nom unNom et de vitesse uneVitesse
	 * placée à l’origine, prête à partir
	 */
	this.unNom = unNom;
	this.uneVitesse = uneVitesse;
	this.position = 0;
	this.sens = 1;
    }
	
    public String toString() {
	/* résultat : retourne une chaîne de caractères contenant les caractéristiques de this (sous la     
	 * forme de votre choix)
	 */
	return (this.unNom + " est à une vitesse de " + this.uneVitesse + " unit. ");
    }
	
    public String toString2() {
    /* résultat : retourne une chaîne de caractères formée d’une suite d’espaces
     * suivie de la première lettre du nom de this, suivie d’un retour
     * à la ligne, le nombre d’espaces étant égal à la position de this.
    */
	String a;
	a = "";
	for (int i = 0; i < this.position; i++) { 
	    a = a + " ";
	}
	a = a + (this.unNom).substring(0, 1) + "\n";
	return a;
    }

    public String leNom() {
    /* résultat : retourne le nom de this */
	return this.unNom;
    }
	
    public boolean depasse(int limite) {
    /* résultat : retourne vrai si et seulement si la position de this est
     * supérieure ou égale à limite
    */
	boolean res;
	res = false;
	
	if (this.position >= limite)
	    res = true;

	return res;
    }
    
    public void faitDemiTour() {
    /* action : fait faire un demi-tour à this */
	if (this.sens == 1){
	    this.sens = -1;
	    this.position = this.position -1;
	}
	else {
	    this.sens = 1;
	    this.position = this.position +1;
	}
    }

    public void avance(int n) {
    /* pré-requis : (rebondissement si on va a gauche de l'origine)
     * action : fait avancer this d’une distance égale à sa vitesse dans son sens de
     * déplacement (à compléter)
    */

	if (n == 1) 
	    this.uneVitesse = Ut.randomMinMax(1, 2); // v1 va moins vite
	else
	    this.uneVitesse = Ut.randomMinMax(3, 4);

	if ((this.uneVitesse > this.position) && (this.sens == -1)) {
	    this.position = this.uneVitesse - this.position;
		this.sens = 1;
	}
	else 
	    this.position = this.sens * (this.position + this.uneVitesse);
    }

    public void acceleration (Voiture v) {
	if (this.position +7 < v.position) {
	    this.position = this.position + 7;
	    System.out.println("BOOST 1");
	}
	else if (v.position +7 < this.position) {
	    v.position = v.position + 6;
	    System.out.println("BOOST 2");
	}
    }
}

public class Course {

    private Voiture voit1;
    private Voiture voit2;
    private int longueurPiste;

    public Course (Voiture voit1, Voiture voit2, int longueurPiste) {
	/* pré-requis : longueur Piste > 0
	 * action : crée une piste de longueur longueurPiste avec voit1 et voit2 au départ
	 */
	this.longueurPiste = longueurPiste;
	this.voit1 = voit1;
	this.voit2 = voit2;
    }
    
    public String toString1() {
	/* résultat : retourne une chaîne de caractères contenant les caractéristiques
	 * de this (sous la forme de votre choix)
	 */
	return (this.voit1 + " et " + this.voit2 + "sont au départ d'une course de " + this.longueurPiste + " m. ");
    }

    public Voiture deroulement () {
	/* pré-requis : this.voit1 et this.voit2 sont sur la ligne de départ
	 * (à l’origine), prêtes à partir
	 * action : simule le déroulement d’une course entre this.voit1 et this.voit2
	 * sur une piste de longueur this.longueurPiste, en affichant à chaque
	 * étape les 2 voitures, représentées par la première lettre de leur
	 * nom, à leur position respective, et retourne la voiture gagnante.
	 */

	System.out.print(this.voit1.toString2());
	System.out.print(this.voit2.toString2());

	while ((!this.voit1.depasse(this.longueurPiste)) && (!this.voit2.depasse(this.longueurPiste))) {

	    this.voit1.acceleration(voit2);

	    if (Ut.randomMinMax(0, 9) < 7) 
		this.voit1.avance(1);
	    else 
		this.voit2.avance(2);

	    Ut.pause(200);
	    Ut.clearConsole();
	    
	    System.out.print(this.voit1.toString2());
	    System.out.print(this.voit2.toString2());

	}
	
	 if (this.voit2.depasse(this.longueurPiste))
	     return (this.voit2);
	 else //if (this.voit2.depasse(longueurPiste))
	     return (this.voit1);
	
    }

}

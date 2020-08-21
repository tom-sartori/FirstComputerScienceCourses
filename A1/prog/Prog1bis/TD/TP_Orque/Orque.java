public class Orque {

    private int id;

    private Arene arene;

    private int taille;

    private int poid;

    private int pdv;

    private Arme arme; 
    

    private static int nbOrques = 0; 
    private static Orque [] tabOrques = new Orque [1000]; 


    public Orque (Arene a) {

	this.id = this.nbOrques;
	this.arene = a; 

	this.tabOrques [this.nbOrques] = this;
	this.nbOrques++;

	this.taille = Ut.randomMinMax(160, 250); 
	this.poid = Ut.randomMinMax(80, 250);
	this.pdv = this.taille + this.poid;

	this.arme = new Arme(); 
    }

    public Orque combat (Orque o1) {
	System.out.println("Combat entre orque " + this.getId() + " et orque " + o1.getId());

	while (this.pdv > 0 && o1.pdv > 0) { //combat tant que pdv > 0
	    if (Ut.randomMinMax(0, 1) == 0) {
		if (this.arme.getTouch() < Ut.randomMinMax(0, 100))
		    this.pdv = this.pdv - this.arme.getDegat();
	    }
	    else {
		if (o1.arme.getTouch() < Ut.randomMinMax(0,100))
		    o1.pdv = o1.pdv - o1.arme.getDegat();
	    }
	}
	
	if (this.pdv > 0) {
	    System.out.println("Victoire de orque " + this.getId() + "\n");
	    return this;
	}
	else {
	    System.out.println("Victoire de orque " + o1.getId() + "\n");
	    return o1;
	}	    
    }

    public int getId() {
	return this.id;
    }

    public static Orque getOrqueById (int i) {
	return Orque.tabOrques[i];
    }

}


	
	    

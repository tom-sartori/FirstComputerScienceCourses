public class Simulation {

    private Ligne[] tabSimu;

    public Simulation () {

	Station Odysseum, Comedie, Mosson;
	Odysseum = new Station ("Odysseum", 5, 3);
	Comedie = new Station ("Comedie", 3, 5);
	Mosson = new Station ("Mosson", 1, 6);

	Station[] tabSttL1 = {Odysseum, Comedie, Mosson};
	/*
	 * Station[] tabSttL1;
	 * tabSttL1 = new Station[3];
	 * tabSttL1[0] = Odysseum; 
	 */

	
	Rame r1;
	r1 = new Rame (1, 1);

	Rame[] tabRame = {r1};

	
	Ligne l1;
	l1 = new Ligne(1, "Bleu", tabRame, tabSttL1);


	Ligne[] tabl = {l1};

	this.tabSimu = tabl;
	
    }

    public void run (int temps) {
	int t;
	t = 0;

	while (t < temps) {
	    for (int i =0; i < this.tabSimu.length; i++) {
		
		this.tabSimu[i].avanceToutesTesRames();
	    }
	    System.out.println(this);



	    //System.out.println(tabSimu[i].toString());


	    t++;
	    
	}
	
    

    }
}

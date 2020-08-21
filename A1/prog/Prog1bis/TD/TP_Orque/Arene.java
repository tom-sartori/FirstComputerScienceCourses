public class Arene {

    private EE ensOrques;
    
    
    public Arene (int nbo) {

	this.ensOrques = new EE (1000); 

	for (int i = 0; i < nbo; i++) {
	    Orque o = new Orque(this);
	    this.ensOrques.ajoutElt(o.getId()); 
	}
    }

    public EE bataille () {
	int o1, o2;
	Orque o; 

	while (this.ensOrques.getCardinal() > 1) {
	    o1 = this.ensOrques.selectEltAleatoirement();
	    o2 = this.ensOrques.selectEltAleatoirement();
	
	    o = Orque.getOrqueById(o1).combat(Orque.getOrqueById(o2));

	    ensOrques.ajoutElt(o.getId());
	    
	}
	return ensOrques; 
    }
}
	

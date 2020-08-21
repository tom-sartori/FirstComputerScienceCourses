
public class Liste {

    private Maillon tete; 


    public Liste () {
	this.tete = null; 
    }

    public Liste (int x) { 
	this.tete = new Maillon(x);   
    }
    
    public Liste (int[] tabListe) {
	this(); 
	if (tabListe.length > 0) {
	    this.tete = new Maillon (tabListe[0]);
	    Maillon curThis = this.tete;
	    for (int i = 1 ; i < tabListe.length ; i++) {
		curThis.setSuiv (new Maillon(tabListe[i])); // creation et accrochage du maillon suivant
		curThis = curThis.getSuiv();
	    }
	}
    }

   /**
     * Prerequis: aucun
     * construit une liste completement disjointe de la liste l 
     */
    public Liste (Liste l) { // constructeur par recopie profonde
	this(); 
	if (! l.estVide()) {

	    this.tete = new Maillon (l.tete.getVal());
	    Maillon curThis = this.tete;
	    Maillon curL = l.tete.getSuiv();

	    while (curL != null) {
		curThis.setSuiv (new Maillon(curL.getVal())); // creation et accrochage du maillon suivant
		curThis = curThis.getSuiv();
		curL = curL.getSuiv();
	    }
	}
    }

    public boolean estVide() {
	return (this.tete == null) ;
    }

    public void ajoutTete (int x) {
	Maillon m = new Maillon(x);
	m.setSuiv(this.tete);
	this.tete=m;
    }

    public boolean contient (int x) {
	Maillon courant = this.tete;
	while (courant != null && courant.getVal() != x) {
	    courant = courant.getSuiv(); 
	}
	return courant != null;
    }

    public String toString() {
	String s = "(";
	Maillon courant = this.tete;
	while (courant != null) {
	    s = s + (courant.getVal()) + ((courant.getSuiv() != null)?", ":"");
	    courant = courant.getSuiv();
	}
	return s + ")";
    }

    public int longueur () {
	Maillon c = this.tete;
	int i = 0;

	while (c != null) {
	    c = c.getSuiv();
	    i++;
	}
	return i;
    }

    public int somme () {
	Maillon c = this.tete;
	int x = 0;

	while (c != null) {
	    x = x + c.getVal(); 
	    c = c.getSuiv();
	}
	return x; 
    }

    public int dernierElt () {
	Maillon c = this.tete;
	int x = 0; 

	while (c != null) {
	    x = c.getVal(); 
	    c = c.getSuiv();
	}	
	return x; 
    }

    public boolean estSupK (int k) {
	return this.longueur() > k; 
    }

    public boolean estLgPaire () {
	return this.longueur() %2 == 0;
    }

    public int maximum () {
	Maillon c = this.tete;
	int x = 0;

	while (c != null) {
	    if (x < c.getVal())
		x = c.getVal();
	    c = c.getSuiv();
	}
	return x;
    }

    public int occurence (int n) {
	Maillon c = this.tete;
	int x = 0;

	while (c != null) {
	    if (c.getVal() == n)
		x++; 
	    c = c.getSuiv(); 
	}
	return x;
    }

    public Maillon dernierMaillon () {
	//pre : this non vide
	Maillon c = this.tete;
	
	while (c.getSuiv() != null)
	    c = c.getSuiv();

	return c; 
    }		    
	    	    
    public void ajoutFin (int n) {
	if (this.estVide())
	    this.ajoutTete(n);
	else 
	    this.dernierMaillon().setSuiv(new Maillon (n)); 
    }

    public void ajoutFinSiAbsent (int n) {
	if (!this.contient(n))
	    this.ajoutFin(n);
    }

    
    public Liste extractionImpairs () {
	Liste l = new Liste(); 
	Maillon c = this.tete;
	
	while (c != null) {
	    if (!(c.getVal() %2 == 0)) 
		l.ajoutFin(c.getVal());
	    c = c.getSuiv(); 
	}
	return l;
    }										
										
    public void suprElt (int n) {						
	Maillon c = this.tete;							
	boolean test = true;							

	if (this.tete.getVal() == n) 
	    this.tete = this.tete.getSuiv();
	else {
	    if (!this.estVide()) {
		while (test && c.getSuiv() != null) {
		    if (c.getSuiv().getVal() == n) {
			c.setSuiv(c.getSuiv().getSuiv());				
			test = false;
		    }						
		c = c.getSuiv();							
		}
	    }
	}
    }

    public void tronc (int n) {
	Maillon c = this.tete; 
	
	if (this.longueur() > n) {
	    for (int i = 1; i < n; i++) 
		c = c.getSuiv();
	    c.setSuiv(null);
	}
    }

    public boolean clone (Liste l) {
	Maillon c = this.tete;
	Maillon d = l.tete;
	
	while (c != null && d != null && c.getVal() == d.getVal()) {
	    c = c.getSuiv();
	    d = d.getSuiv();  
	}
	if (c == d)
	    return true;
	else
	    return false;
    }

    public Liste inverse () {
	Liste l = new Liste();
	
	if (!this.estVide()) {
	    Maillon c = this.tete;

	    while (c != null) {
		l.ajoutTete(c.getVal());
		c = c.getSuiv();	
	    }
	}
	return l;
    }
    
    public void suppToutesOcc (int n) {

	while (this.occurence(n) > 0)
	    this.suprElt(n);
    }
		
	
    
} // end class

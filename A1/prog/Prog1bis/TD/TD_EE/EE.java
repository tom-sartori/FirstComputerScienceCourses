public class EE {

    private int [] ensTab;
    private int cardinal;

    public EE (int max) {
	this.ensTab = new int[max];
	this.cardinal = 0;
    }

    public EE (int max, int[] tab) {
	this(max);
	this.cardinal = tab.length;

	for (int i =0; i < this.cardinal; i++)
	    this.ensTab[i] = tab[i]; // appel à ajoutElt()
    }

    public EE (EE e1) {
	this.cardinal = e1.cardinal;
	this.ensTab = new int[e1.ensTab.length];

	for (int i =0; i < this.cardinal; i++)
	    this.ensTab[i] = e1.ensTab[i];
    }

    public EE (int max, String chiffres) {
	this(max);
	String[] tab;

	tab = chiffres.split(" "); 

	this.cardinal = tab.length;

	for (int i =0; i < this.cardinal; i++)
	    this.ensTab[i] = Integer.parseInt(tab[i]); 
    }
	
    public String toString () {
	String ch;
	int i; 

	ch = "{"; 
	if (this.cardinal != 0) {
	    for (i =0; i < this.cardinal; i++)
		ch = ch + this.ensTab[i]  + ",";
	    
	    ch = ch.substring(0, ch.length()-1);
	}
	ch = ch + "}";

	return ch;
    }

    public int getCardinal () {
	return this.cardinal;
    }

    private int contientPratique (int x) { //check si x dans ensemble et renvois index
	int i, res;
	i = 0;
	res = -1; 

	while (i < this.cardinal && res == -1) {
	    if (this.ensTab[i] == x)
		res = i;
	    i++;
	}
	
	return res;
    }

    public boolean contient (int x) { //check si contient x et renvois boolean
	
	if (this.contientPratique(x) == -1) // une ligne
	    return false;
	else
	    return true; 
    }

    private void ajoutPratique (int e) {
	    
	    this.ensTab[this.cardinal] = e;
	    this.cardinal++;
    }

    private int retraitPratique (int i) { //retire à l'index i
	int res;
	res = this.ensTab[i];
	this.ensTab[i] = this.ensTab[this.cardinal -1];
	this.cardinal--;
	return res;
    }

    public boolean estVide () {

	if (this.cardinal == 0) // une ligne
	    return true;
	else
	    return false;
    }

    public boolean deborde () {
	
	if (this.cardinal == this.ensTab.length) // une ligne
	    return true;
	else
	    return false;
    }

    public boolean retraitElt (int x) { //renvois boolean et enleve x de l'ens si possible
	int i; 
	i = this.contientPratique(x); 
	if (i == -1)
	    return false;
	else {
	    this.retraitPratique(i);
	    return true;
	}	
    }

    public int ajoutElt (int x) {
	if  (this.contient(x))
	    return 0;
	else if (this.deborde())
	    return -1;
	else {
	    this.ajoutPratique(x);
	    return 1;
	}
    }

    public boolean estInclus (EE e1) {
	for (int i = 0; i < this.cardinal; i++) 
	    if (!e1.contient(this.ensTab[i]))
		return false;
	return true;
    }

    public boolean estEgale (EE e1) {
	return (this.cardinal == e1.getCardinal()) && (this.estInclus(e1));
    }

    public boolean estDisjoint (EE e1) {
	for (int i =0; i < this.cardinal; i++) 
	    if (e1.contient(this.ensTab[i]))
		return false;
	return true;
    }

    public void intersection (EE e1) {
	// Resultat : un nouvel ensemble qui contient les éléments de this et de e1
	
	for (int i = 0; i < this.cardinal; i++) 
	    if (!e1.contient(this.ensTab[i])) {
		this.retraitPratique(i);
		i--;
	    }
    }
    
    public EE reunion (EE e1) {
	EE e;
	e = new EE (this.ensTab.length + e1.ensTab.length);
	
	for (int i = 0; i < this.cardinal; i++) // OK mais constructeur par recopie
	    e.ajoutElt(this.ensTab[i]);
	
	for (int i =0; i< e1.cardinal; i++) 
	    e.ajoutElt(e1.ensTab[i]);
	
	return e;
    }
			
    public void difference (EE e1) { // Résultat EE

	for (int i =0; i< this.cardinal; i++) 
	    if (e1.contient(this.ensTab[i])) {
		this.retraitPratique(i);
		i--; 
	    }
    }
   
}

public class Date {
    
    private int an;
    private int mois;
    private int jour;

    public Date (int jour, int mois, int an) {
	this.jour = jour;
	this.mois = mois;
	this.an = an;
    }

    public String toString () {
	return (this.jour + "/" + this.mois + "/" + this.an);
    }
    
    public String toStringLettre() {
	String[] tab = {"janvier", "février", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "decembre"};

	return(this.jour + tab[this.mois -1] + this.an);
    }

    
    public boolean bisextile(int an) {
	boolean estBi;

	estBi = false;

	if (an%4 == 0) {
	    if (an%100!=0 | an%400==0) 
		estBi = true;
	    else 
		estBi = false;
	}
	return estBi;
    }

    public void lendemain() {

	if (this.jour < 28)
	    this.jour = this.jour +1;
	else if ((this.mois <= 7 && this.mois %2 != 0) || (this.mois >= 8 && this.mois %2 == 0)) { //mois en 31 
	    if (this.jour < 31)
		this.jour = this.jour +1;
	    else {
		jour = 1;
		this.mois = this.mois +1;
	    }
	}
	else if (this.mois == 2) {
	    if (bisextile(this.an)) { //année bi et on est le 28 donc go 1 mars
		this.jour = 1;
		this.mois = this.mois +1;
	    }
	    else { //année normale donc go 29 ou 1 mars
		this.jour = this.jour +1;
		if (this.jour > 29) {
		    this.jour = 1;
		    this.mois = this.mois +1;
		}
	    }
	}
	else { //les autres mois donc mois en 30
	    if (this.jour < 30)
		this.jour = this.jour +1;
	    else {
		jour = 1;
		this.mois = this.mois +1;
	    }
	}
	if (this.mois > 12) {
	    this.mois = 1;
	    this.an = this.an +1;
	}
    }
    public Date incrementation() {
	Date date = new Date (this.jour, this.mois, this.an);
	date.lendemain();
	return date;
    }

    public boolean dateEgale(Date d) {
	boolean estEgale;
	estEgale = false;
	if (this.an == d.an) {
	    if (this.mois == d.mois) {
		if (this.jour == d.jour)
		    estEgale = true;
	    }
	}
	return estEgale;
    }
    public boolean dateAnterieure(Date d) {
	boolean estAnterieure;
	estAnterieure = false;

	if (this.an < d.an)
	    estAnterieure = true;
	else if (this.an > d.an)
	    estAnterieure = false;
	else if (this.mois < d.mois)
	    estAnterieure = true;
	else if (this.mois > d.mois)
	    estAnterieure = false;
	else if (this.jour < d.jour)
	    estAnterieure = true;
	else if (this.jour > d.jour)
	    estAnterieure = false;

	return estAnterieure;
	    }

    public int dateDifference(Date d) {
	int count;
	count = 0;

	Date da;
	da = new Date(this.jour, this.mois, this.an);
	
	while ((da.an != d.an) || (da.mois != d.mois) || (da.jour != d.jour)) {
	    da.lendemain();
	    count++;
	}
	return count;
    }
}
    


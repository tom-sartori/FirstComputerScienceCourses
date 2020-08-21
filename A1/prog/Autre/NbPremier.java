public class NbPremier {
    // Recherche nb premier
    public static void main(String[] args) {
	int  n, stop;
	double x;
	n=0;
	x=((Math.pow(2,n-1))-1);
	
	Ut.afficher("stop = ");
	stop = Ut.saisirEntier();
	while (n <= stop) {
	    x=((Math.pow(2,n-1))-1);
	    if (x%n ==0){
		Ut.afficher(n + " est un premier" + "\n");
	    }
	    n=n+1;
	}}}
	    

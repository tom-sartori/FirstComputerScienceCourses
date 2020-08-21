public class OrdreCroissant {
    // 4 variables dans l'ordre croissant
    public static void main(String[] args) {
	int x, i;	
	int[] tab;
	
	tab = new int[4];
	Ut.afficher("Liste = " + tab + "\n");

	for (i=0; i<=3;i++){
	    Ut.afficher("Liste = " + tab[i] + " "); Ut.afficher("\n");
	}
	
	Ut.afficher("n = ");
	x = Ut.saisirEntier();

	tab[0]=x;


	for (i=0; i<=2;i++){
	    Ut.afficher("n = ");
	    x = Ut.saisirEntier();

	    if (tab[0]<x){
		if (tab[1]<x){
		    if (tab[2]<x){
			tab[3]=x;
		    }
		    else {
			tab[3]=tab[2];
			tab[2]=x;
		    }}
		else{
		    tab[3]=tab[2];
		    tab[2]=tab[1];
		    tab[1]=x;
		}}
	    else{
		tab[3]=tab[2];
		tab[2]=tab[1];
		tab[1]=tab[0];
		tab[0]=x;
	    }
	    
	    
	}
	for (i=0; i<=3;i++){
	    Ut.afficher("Liste = " + tab[i] + " "); Ut.afficher("\n");
	

	}
	
    }
}

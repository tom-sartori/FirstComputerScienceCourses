public class Ligne {

    private int numLigne;
    private String couleurLigne;
    private Rame[] tabRames;
    private Station[] tabStations; 

    public Ligne (int num, String couleur, Rame[] tabR, Station[] tabS) {

	this.numLigne = num;
	this.couleurLigne = couleur;
	this.tabRames = tabR;
	this.tabStations = tabS; 
    }

    public void avanceToutesTesRames(){
	for (int i =0; i < tabRames.length; i++) 
	    tabRames[i].avance();
    }

    public String toString () {
	String ch;
	ch = "Ligne numero : " + this.numLigne + "\n ";
	for (int i = 0; i < this.tabRames.length; i++) {
 	    ch = ch + "Ma ram : " + this.tabRames[i] + " est à la station : " + tabRames[i].toStringRame();
	}
	return ch;
	
	
	// affiche nom ligne et toutes les rames et le to string des rames
    }
}
	    

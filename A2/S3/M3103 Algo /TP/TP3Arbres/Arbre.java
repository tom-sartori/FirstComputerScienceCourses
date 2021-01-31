public class Arbre {

	private int val; 
	private Arbre filsG; 
	private Arbre filsD; 


	public static  void main(String [] args) {
		Arbre arbre = new Arbre(); 
		Arbre arbre1 = new Arbre();
		Arbre arbre2 = new Arbre(); 
		arbre.filsG = arbre1; 
		arbre.filsD = arbre2; 
		arbre.val = 3;  

		arbre1.val = 4; 
		arbre2.val = 5; 
		
		arbre1.filsG = new Arbre(); 
		arbre1.filsD = new Arbre(); 
		arbre2.filsG = new Arbre(); 
		arbre2.filsD = new Arbre(); 

		System.out.println(arbre.toStringV2()); 

		System.out.println(arbre.symetrise().toStringV2()); 
	}

	public Arbre () {
		filsG = null; 
		filsD = null; 
	}

	public boolean estVide() {
		return filsG == null; 
	}

	String toStringNaif () {
		if ( estVide () )
			return " " ;
		else
			return filsG . toStringNaif () + " ␣ " + this . val + " ␣ " +
		filsD . toStringNaif () ;
	}

	public String toStringV2aux ( String s ) {
		// pre : aucun
		// resultat : retourne une chaine de caracteres 
		// permettant d ’ afficher this dans un
		// terminal ( avec l ’ indentation du dessin
		// precedent , et en ajoutant s au debut de
		// chaque ligne ecrite ) et passe a la ligne
		// apres chaque entier ecrit
		if ( estVide () )
			return " " ;
		else
			return filsD . toStringV2aux ( s + " ␣ ␣ ␣ " ) + s + val + " \n " + filsG . toStringV2aux ( s + " ␣ ␣ ␣ ");
	}

	public String toStringV2 () {
		// pre : aucun
		return toStringV2aux ( " " );
	}

	public int nbFeuilles () {
		if (estVide())
			return 0; 
		else {
			if (filsG.estVide() && filsD.estVide())
				return 1;
			else 
				return filsG.nbFeuilles() + filsD.nbFeuilles(); 
		}
	}

	public Arbre symetrise() {
		Arbre sym = new Arbre(); 
		if (!estVide()) {
			sym.val = val; 
			sym.filsG = filsD.symetrise(); 
			sym.filsD = filsG.symetrise();  
		}
		return sym; 
	}

	public boolean parcours(Liste l) {
		if (estVide())
			return l.estVide(); 
		else {
			return !estVide() && (val == l.val) && (filsG.parcours(l.suiv) || filsD.parcours(l.suiv)); 
		}
	}

	public int traverse() {
		if (filsG.estVide()) {
			if (filsD.estVide())
				return val; 
			else 
				return val + filsD.traverse(); 
		}
		else {
			if (filsD.estVide())
				return val + filsG.traverse(); 
			else 
				return val + Math.min(filsG.traverse(), filsD.traverse()); 
		}
	}
}

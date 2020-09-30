class Baguenaudier {

	private static int nbCases; 
	private static char [] tab; 


	public Baguenaudier(int n) {
		this.nbCases = n; 
		this.tab = new char[nbCases]; 

		for (int i = 0; i < nbCases; i++)
			tab[i] = '.'; 
	}

	public static void main(String args[]) {
		Baguenaudier b = new Baguenaudier(4); 
		b.remplir();
		System.out.println("Fin");
		b.vider(); 
	}



	public static void remplir() {
		//afficher(); 
		//tab[0] = '*'; 
		afficher(); 
		remplirAux(nbCases);
	}

	public static void remplirAux(int n) {
		if (n == 1) {
			switcher(0);
			afficher(); 
		}
		else if (n == 2) {
			switcher(1);
			afficher(); 
		}
		else {
			remplirAux(n-1); 
			viderAux(n-2);

			switcher(n-1); 
			afficher(); 

			remplirAux(n-2); 
		}
	}


	public static void vider() {
		afficher(); 
		viderAux(nbCases);
		tab[0] = '.';
		afficher();
	}

	public static void viderAux(int n){
		if (n == 1) {
			switcher(0);
			afficher(); 
		}
		else if (n == 2) {
			switcher(1);
			afficher(); 
		}
		else{
			viderAux(n-2);

			switcher(n-1);
			afficher(); 

			remplirAux(n-2); 	
			viderAux(n-1);	
		}
	
	}


	public static void afficher() {
		for (int i = 0; i < nbCases; i++) 
			System.out.print(tab[i]); 
		System.out.print('\n'); 
	}

	public static void switcher(int n) {
		if (tab[n] == '.')
			tab[n] = '*'; 
		else 
			tab[n] = '.'; 
	}


/*
	public static void remplirAux(int n) {
		if (n == 1) 
			System.out.println(0);
		else if (n == 2)
			System.out.println(1);
		else {
			remplirAux(n-1); 
			viderAux(n-2);
			System.out.println(n-1); 
			remplirAux(n-2); 
		}
	}

	public static void viderAux(int n){
		if (n == 1)
			System.out.println(0);
		else if (n == 2)
			System.out.println(1);
		else{
			remplirAux(n-1); 
			viderAux(n-2); 
			System.out.println(n-1);
			remplirAux(n-2);		
		}
*/
}
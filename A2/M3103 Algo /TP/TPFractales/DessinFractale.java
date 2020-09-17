class DessinFractale{
	private final Turtle bob;

	private final static int LARGEUR = 800;
	private final static int HAUTEUR = 600;
    //taille de la fenetre graphique

	public static void main(String[] args){
		DessinFractale d = new DessinFractale(500);

		//d.carre(50); 
		//d.vonKoch(100, 10);
		d.reset(); 
		d.arbre(100, 0); 

		/*
		d.carre(90);
		d.reset();
		d.carre(60);
		d.reset();
		d.close();
		*/
	}

	public DessinFractale(){
		bob  = new Turtle();
		Turtle.setCanvasSize(LARGEUR,HAUTEUR);//à appeler APRES création de la tortue
	}

	public DessinFractale(int v){
		//attention, plus v est grand, plus bob va lentement !
		this();
		bob.speed(v);
	}


	public void reset(){
		bob.clear();
		bob.up();
		bob.setPosition(0,0);
		bob.setDirection(90);
		bob.down();

	}

	public void close(){
		bob.exit();
	}


	public void carre(double l){
		for (int i = 0; i < 4; i++) {
			bob.forward(l); 
			bob.left(90);
		}
	}

	public void vonKoch(double l, int n) {
		bob.speed(0);
		if (n == 0) 
			bob.forward(l); 
		else {
			vonKoch(l/3, n-1); 
			bob.right(315); 

			vonKoch(l/3, n-1); 
			bob.left(270); 

			vonKoch(l/3, n-1); 
			bob.right(315); 

			vonKoch(l/3, n-1); 
		}
	}

	public void arbre(double l , int n) {
		if (n == 0) {
			bob.forward(l); 
			bob.left(180); 
			bob.forward(l); 
			bob.left(180); 
		}

		else {
			bob.left(45);
			arbre(l/3, n-1); 
			bob.left(45);
			arbre(l/3, n-1);  
		}
	}

}
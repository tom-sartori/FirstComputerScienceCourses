class DessinFractale{
	private final Turtle bob;

	private final static int LARGEUR = 500;
	private final static int HAUTEUR = 500;
    //taille de la fenetre graphique

	public static void main(String[] args){
		DessinFractale d = new DessinFractale(500);

		//d.carre(50); 
		//d.vonKoch(100, 10);
		
		//d.reset(); 
		//d.arbre(150, 8); 

		//d.triforce(300, 3); 

		d.dragon(100, 15); 

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
		bob.speed(2);
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
			bob.forward(l/2); 
			arbre(l/3, n-1); 
			bob.left(45);
			arbre(l/3, n-1); 
			bob.right(90);
			arbre(l/3, n-1); 
			bob.right(135); 
			bob.forward(l); 
			bob.right(180); 
		}
	}

	public void triforce(double l, int n) {
		if (n == 0) {
			for (int i = 0; i < 3; i++) {
				bob.forward(l); 
				bob.left(120); 
			}

		}
		else {
			triforce(l/2, n-1); 
			bob.forward(l/2); 
			triforce(l/2, n-1); 
			bob.forward(l/2); 
			bob.left(120); 
			bob.forward(l/2); 
			triforce(l/2, n-1); 
			bob.left(60); 
			bob.forward(l/2); 
			bob.left(60); 
			bob.forward(l/2); 
			bob.left(120); 

		}

	}





	public void dragon( double l , int n) {
		if(n>0){
			dragon(l,n-1);
			bob.left(90);
			inverseDragon(l,n-1);
		}
		else{
			bob.forward(l);
		}
	}

	public void inverseDragon(double l , int n) {
		if (n > 0) {
			dragon(l, n - 1);
			bob.right(90);
			inverseDragon(l, n - 1);
		} else {
			bob.forward(l);
		}
	}


}








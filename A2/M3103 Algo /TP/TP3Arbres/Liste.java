class Liste {

	private int val; 
	private Liste suiv; 

	public Liste() {
		suiv = null; 
	}

	public boolean estVide() {
		return suiv == null; 
	}
}
import java.util.Random;

class ATache implements Runnable  { // implémentation de l'interface Runnable
	int nom;   // nom de la tâche
	int index; // index de la boucle d'affichage
	/** constructeur
	* @param ident le nom de la tâche, entier >= 1  */
	public ATache (int ident){
	  this.nom = ident;
	  this.index = 1;
	}
	public void run () {
	  System.out.println(" début tâche T"+this.nom);
          Random rand = new Random();
	  int pause;
          while (index <= 30){
	    try{
		System.out.println("indice: " + index + ", tâche T" + this.nom);
                pause = rand.nextInt(100) + 100;
		Thread.sleep(pause);
		index++;
		} catch(InterruptedException e) {
				System.out.println("Interrupted Exception caught");}
	   }
	  System.out.println("Fin tâche T"+this.nom);
	}
 }

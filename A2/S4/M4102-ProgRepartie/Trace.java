

class Trace implements Runnable 
	{
	int nom;                   // identifiant de la tâche
        static char[] S1 = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
        String B;
        public Trace (int ident){  // constructeur
		nom = ident;
		B = new String(S1,0,ident);
	}		
	public void run () {
		System.out.println(" début tâche T"+this.nom);
                for (int index = 0; index < 300; index ++) {
			System.out.println(nom + " \t|" + B + 'x');
//                        try {

//			 if (nom < 10) Thread.sleep(10);
			 Thread.yield();
//                        } catch (InterruptedException e) {     }
		}
		System.out.println("Fin tâche T"+this.nom);
		}
}

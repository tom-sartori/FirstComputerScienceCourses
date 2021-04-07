// Fichier:_partage.java

public class partage extends Thread {

    private static String chaineCommune = "";
    private static int cpt = 0;
    private String nom;

    partage ( String s ) {
        nom = s;
    }

    public void run() {
       for (int i = 0; i<10; i++)
        {
          maj(nom); // mises a jour
        try {
             sleep(100);  // milliseconds
            } catch(InterruptedException e) {}
        }
    }

   public  void maj(String nn){
        chaineCommune = chaineCommune + nn;
        cpt++;
   }

    public static void main(String args[]) {
        Thread T1 = new partage( "T1 " );
        Thread T2 = new partage( "T2 " );
        Thread T3 = new partage( "T3 " );
        T1.start();
        T2.start();
        T3.start();
        try {
            T1.join();
            T2.join();
            T3.join();
            } catch(InterruptedException e) {}
        System.out.println( chaineCommune );
        System.out.println( cpt );
    }
}

 

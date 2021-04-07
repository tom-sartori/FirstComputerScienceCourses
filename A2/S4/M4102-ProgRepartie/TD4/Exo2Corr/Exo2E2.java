package td4;

import java.lang.Runnable;
import java.util.concurrent.Semaphore;

import java.util.Random;

public class Exo2E2 {

    //etape 1
    public static class ATache implements Runnable { // 
        int nom; // nom de la tache ´
        int index; // index de la boucle d’affichage
        
        Semaphore privee;
        Semaphore next;

        static  int min = 500;
        static  int max = 1000;
        


        /** constructeur
        * @param ident le nom de la tÃcche, entier >= 1 ´ */
        
        public ATache (int ident, Semaphore privee, Semaphore voisin){
        this.nom = ident;
        this.index = 1;
        this.next = voisin;
        this.privee = privee;
        }
        
        public void run () 
        {

            System.out.println(" debut de la tache T"+this.nom);
            Random rand = new Random();
            int pause;

            while (index <= 30){
            try{
                //demande pour passer !
                this.privee.acquire();
                
                System.out.println("indice: " + index + ", tache T" + this.nom);
                pause = rand.nextInt(max - min + 1) + min;
                
                Thread.sleep(pause);

                index++;

                //je libere mon voisin
                this.next.release();


            } catch(InterruptedException e) {
            System.out.println("Interrupted Exception caught");}        
            }
        System.out.println("Fin tache T"+this.nom);
    }
    }


    public static void etape2(){
        try {
            
        Semaphore semaphore1 = new Semaphore(0,true); // ici !!
        Semaphore semaphore2 = new Semaphore(0,true);
        Semaphore semaphore3 = new Semaphore(1,true); // ici !!
        
        ATache t1 = new ATache(1, semaphore1, semaphore3); // ICI
        ATache t2 = new ATache(2, semaphore2, semaphore1); // ICI
        ATache t3 = new ATache(3, semaphore3, semaphore2); // ICI
        
        Thread thd1 = new Thread(t1);
        Thread thd2 = new Thread(t2);
        Thread thd3 = new Thread(t3);
        thd1.start();
        thd2.start();
        thd3.start();
        
        thd1.join();
        thd2.join();
        thd3.join();
    } catch (Exception e) 
    {
        e.printStackTrace();
    }


    }


    public static void main(String[] args) {
        etape2();    
    }
}

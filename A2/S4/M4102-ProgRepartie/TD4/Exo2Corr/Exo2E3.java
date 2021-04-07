package td4;

import java.lang.Runnable;
import java.util.concurrent.Semaphore;

import java.util.Random;

public class Exo2E3 {

    //etape 1
    public static class ATache implements Runnable { // 
        int nom; // nom de la tache ´
        int index; // index de la boucle d’affichage
        
        Semaphore privee;
        Semaphore next;

        Semaphore semFin; //ICI 
        

        static  int min = 50;
        static  int max = 100;
        


        /** constructeur
        * @param ident le nom de la tÃcche, entier >= 1 ´ */
        
        public ATache (int ident, Semaphore privee, Semaphore voisin, Semaphore semFin){
        this.nom = ident;
        this.index = 1;
        this.next = voisin;
        this.privee = privee;
        this.semFin = semFin;
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
        this.semFin.release();

    }
    }


    public static void etape3(){
        try {
            
        Semaphore semaphore1 = new Semaphore(0,true); 
        Semaphore semaphore2 = new Semaphore(0,true);
        Semaphore semaphore3 = new Semaphore(1,true); 
       
        Semaphore barriereFin = new Semaphore(-2,true); //<<< ici !!
       
        ATache t1 = new ATache(1, semaphore1, semaphore3,barriereFin); 
        ATache t2 = new ATache(2, semaphore2, semaphore1,barriereFin); 
        ATache t3 = new ATache(3, semaphore3, semaphore2,barriereFin); 
        
        Thread thd1 = new Thread(t1);
        Thread thd2 = new Thread(t2);
        Thread thd3 = new Thread(t3);
        thd1.start();
        thd2.start();
        thd3.start();
        
        barriereFin.acquire();//<<
        System.out.println("Fin de la tache principale");

    } catch (Exception e) 
    {
        e.printStackTrace();
    }


    }


    public static void main(String[] args) {
        etape3();    
    }
}

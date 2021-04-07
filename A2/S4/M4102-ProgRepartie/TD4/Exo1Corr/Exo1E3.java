package td4;
//Etape numero 2 : maintenant avec synchronized observez le resultat: l affichage se comporte correctement avec le calcul
//cela veut bien dire que tant que le calcul n a pas termine son operation entierement l affichage ne peut pas se faire a partir d un autre thread
//il existe bien un jeton associe d l instance et que chaque thread demande pour executer une fonction synchronized
//Cependant les deux threads ne sont pas coordonnees en terme de rythme: on peut avoir deux affichages du meme nombre; on peut avoir aussi des nombres non affiches
// c est l objetif de l etape 3
public class Exo1E3{

    public static class Nombres {
        protected int n;
        protected int carre;

        protected boolean pret ;

        public Nombres(int i){
            this.n = i;
            this.carre = i*i;
            this.pret = false;
        }

        synchronized public void calcul()   throws InterruptedException 
        {
            this.pret = false;
            this.n++;
            Thread.sleep(100);
            this.carre = this.n*this.n;
            this.pret = true;
        }

        synchronized public void affiche()throws InterruptedException 
        {
            if(this.pret)
            {
                System.out.printf("Le carre de %d est %d\n",this.n,this.carre);
            }
        }

    }


    public static class Calcul extends Thread{

        protected Exo1E3.Nombres nombre;
        protected boolean alive;
        protected Object barriere1 ;
        protected Object barriere2 ;
        

        public Calcul(Exo1E3.Nombres n,Object barriere1, Object barriere2){
            this.nombre = n ;
            this.alive = true;
            this.barriere1 = barriere1;
            this.barriere2 = barriere2;
        }
        
        public void run() {
            while(this.alive)
            {
                try{   
                
                    // attente du droit de calcul (attention au depart on doit initier le processus)
                if(nombre.pret)
                {
                    synchronized(this.barriere2)
                    {
                    this.barriere2.wait();
                    }
                }
                //passage de la barriere du calcul

                 
                Thread.sleep(100);
                nombre.calcul();
                } catch (InterruptedException e) {
                //TODO: handle exception
                this.alive = false;
                }

                //ouverture de la barriere de l affichage

                synchronized(this.barriere1)
                {
                    this.barriere1.notifyAll();
                }
            }
        }

    }

    static public class Affiche extends Thread {
        
        protected Exo1E3.Nombres nombre;
        protected boolean alive;
        protected Object barriere1 ;
        protected Object barriere2 ;
        
        public Affiche(Exo1E3.Nombres n, Object barriere1, Object barriere2)
        {
            this.nombre = n ;
            this.alive = true;
            this.barriere1 = barriere1;
            this.barriere2 = barriere2;
        }

        public void run() {
            while(this.alive)
            {
                try {
                    //on inverse la logique ici:
                    // attente de la barriere d affichage
                    synchronized(this.barriere1){
                        this.barriere1.wait();
                    }

                    Thread.sleep(50);
                    nombre.affiche();
                    
                    //ouverture de la barriere de calcul
                    synchronized(this.barriere2)
                    {
                        this.barriere2.notifyAll();
                    }

        
                } catch (InterruptedException e) {
                    //TODO: handle exception
                    this.alive = false;
                }
            }
        }

    } 


    public static void main(String[] args) {
        
        System.out.println("debut du programme");
        try{
            Exo1E3.Nombres nombre = new Exo1E3.Nombres(1);
            Object barriereEcriture = new Object();
            Object barriereLecture = new Object();
            
            Exo1E3.Calcul tacheCalcul = new Exo1E3.Calcul(nombre,barriereEcriture,barriereLecture);
            Exo1E3.Affiche tacheAffiche = new Exo1E3.Affiche(nombre,barriereEcriture,barriereLecture);
        
        tacheCalcul.start();
        tacheAffiche.start();

        Thread.sleep(5000);

        tacheCalcul.alive = false;
        tacheAffiche.alive = false;
        
        tacheCalcul.join();
        tacheAffiche.join();

        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("fin du programme");

        
    }
}
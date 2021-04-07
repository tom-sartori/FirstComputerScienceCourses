package td4;
//Etape numero 2 : maintenant avec synchronized observez le resultat: l affichage se comporte correctement avec le calcul
//cela veut bien dire que tant que le calcul n a pas termine son operation entierement l affichage ne peut pas se faire a partir d un autre thread
//il existe bien un jeton associe d l instance et que chaque thread demande pour executer une fonction synchronized
//Cependant les deux threads ne sont pas coordonnees en terme de rythme: on peut avoir deux affichages du meme nombre; on peut avoir aussi des nombres non affiches
// c est l objetif de l etape 3
public class Exo1E2{

    public static class Nombres {
        protected int n;
        protected int carre;

        public Nombres(int i){
            this.n = i;
            this.carre = i*i;
        }

        synchronized public void calcul()   throws InterruptedException 
        {
            this.n++;
            Thread.sleep(100);
            this.carre = this.n*this.n;
        }

        synchronized public void affiche()throws InterruptedException 
        {
            System.out.printf("Le carre de %d est %d\n",this.n,this.carre);
        }

    }


    public static class Calcul extends Thread{

        protected Exo1E2.Nombres nombre;
        protected boolean alive;

        public Calcul(Exo1E2.Nombres n){this.nombre = n ;
        this.alive = true;
    }
        
        public void run() {
            while(this.alive)
            {
             try{   Thread.sleep(100);
                nombre.calcul();
            } catch (InterruptedException e) {
                //TODO: handle exception
                this.alive = false;
            }
            }
        }

    }

    static public class Affiche extends Thread {
        
        protected Exo1E2.Nombres nombre;
        protected boolean alive;
        public Affiche(Exo1E2.Nombres n)
        {
            this.nombre = n ;
            this.alive = true;
        }

        public void run() {
            while(this.alive)
            {
                try {
                    Thread.sleep(50);
                    nombre.affiche();
        
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
            Exo1E2.Nombres nombre = new Exo1E2.Nombres(1);
            Exo1E2.Calcul tacheCalcul = new Exo1E2.Calcul(nombre);
            Exo1E2.Affiche tacheAffiche = new Exo1E2.Affiche(nombre);
        
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
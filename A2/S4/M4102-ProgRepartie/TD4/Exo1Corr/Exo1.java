package Exo1Corr;
//Premiere etape de l exerice qui montre bien que nous avons un probleme de sync : entre le calcul et l affichage !!
public class Exo1{

    public static class Nombres {
        protected int n;
        protected int carre;

        public Nombres(int i){
            this.n = i;
            this.carre = i*i;
        }

        public void calcul()   throws InterruptedException 
        {
            this.n++;
            Thread.sleep(100);
            this.carre = this.n*this.n;
        }

        public void affiche()throws InterruptedException 
        {
            System.out.printf("Le carre de %d est %d\n",this.n,this.carre);
        }

    }


    public static class Calcul extends Thread{

        protected Exo1.Nombres nombre;
        protected boolean alive;

        public Calcul(Exo1.Nombres n){this.nombre = n ;
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
        
        protected Exo1.Nombres nombre;
        protected boolean alive;
        public Affiche(Exo1.Nombres n)
        {
            this.nombre = n ;
            this.alive = true;
        }

        public void run() {
            while(this.alive)
            {
                try {
                    Thread.sleep(150);
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
        Exo1.Nombres nombre = new Exo1.Nombres(1);
        Exo1.Calcul tacheCalcul = new Exo1.Calcul(nombre);
        Exo1.Affiche tacheAffiche = new Exo1.Affiche(nombre);
        
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
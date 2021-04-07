package TD5;

import java.util.concurrent.Semaphore;

public class BalSimple {
    String message;
    Semaphore sDepot, sRetrait;

    public BalSimple() {
        // initialisation des s\’emaphores
        sDepot = new Semaphore(1);
        sRetrait = new Semaphore(0);
    }
    public void deposeRequete(String mess) {
        /* - attendre que la BAL soit vide
        - d\’eposer le message dans la BAL - indiquer que la BAL est pleine
        */
        System.out.println("Depose rq. | message : " + message);
        try {
            sDepot.acquire();
            message = mess;
            sRetrait.acquire();
            //sDepot.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Depose rq. | message : " + message);
    }

    public String retireRequete(){
        /* - attendre que la BAL soit pleine - lire le message
        - indiquer que la BAL est vide
        - renvoyer le message
        */

        String m = "";
        System.out.println("Retire rq. | message : " + message);
        try {
            sDepot.release();
            m = message;
            message = "";
            sDepot.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Retire rq. | message : " + message);
        return m;
    }

}

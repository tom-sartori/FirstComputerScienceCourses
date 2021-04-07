package TD5;

public class Serveur extends Thread {

    String id;
    BalSimple balSimple;

    public Serveur(String id, BalSimple bal) {
        this.id = id;
        this.balSimple = bal;
    }

    @Override
    public void run() {
        balSimple.deposeRequete(id);
    }
}

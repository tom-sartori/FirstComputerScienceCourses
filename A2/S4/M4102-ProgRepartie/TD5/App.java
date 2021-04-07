package TD5;

public class App {


    public static void main(String[] args) {
        BalSimple balSimple = new BalSimple();
        Client client = new Client("01", balSimple);
        Serveur serveur = new Serveur("10", balSimple);

        serveur.start();
        client.run();

    }
}

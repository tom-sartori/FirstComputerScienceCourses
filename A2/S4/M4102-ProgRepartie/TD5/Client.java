package TD5;

public class Client implements Runnable {

    String id;
    BalSimple balSimple;

    public Client(String id, BalSimple bal) {
        this.id = id;
        this.balSimple = bal;
    }


    @Override
    public void run() {
        balSimple.retireRequete();
    }
}

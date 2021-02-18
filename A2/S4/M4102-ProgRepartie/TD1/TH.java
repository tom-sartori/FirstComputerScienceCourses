package TD1;

public class TH extends Thread {


    private Activite activite;


    public TH(int id, int lng, int pause) {
        activite = new Activite(id, pause, lng);
    }

    public void run() {
        activite.faire();
    }

    public static void main(String[] args) {
        //int n = Integer.parseInt(args[0]);


        TH th1 = new TH(1, 30, 100);
        th1.start();
        System.out.println(th1.getState());

        TH th2 = new TH(2, 30, 200);
        th2.start();

        TH th3 = new TH(3, 10, 500);
        th3.start();


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(th1.getState());



    }
}

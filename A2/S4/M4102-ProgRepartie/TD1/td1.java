package TD1;

public class td1 {
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

    // Avec :

    public void run() {
        int n = 2;

        for (int i = 0; i < 100; i++) {

            System.out.println(n + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
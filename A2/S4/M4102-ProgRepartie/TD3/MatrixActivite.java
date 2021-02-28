package TD3;

public class MatrixActivite implements Runnable {

    private Matrix A;
    private Matrix B;
    private Matrix C;
    private int x;
    private int y;

    public MatrixActivite(Matrix a, Matrix b) {
        A = a;
        B = b;
        C = new Matrix(A.M, B.N);
        x = (int)(C.M / 2);
        y = (int)(C.N / 2);
    }

    @Override
    public void run() {

    }
}

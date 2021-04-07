package TD3;

public class MatrixActivite implements Runnable {

    // Pattern design command

    private Matrix A;
    private Matrix B;
    private Matrix C;
    private int startI;
    private int endI ;
    private int startJ;
    private int endJ;

    public MatrixActivite(Matrix a, Matrix b, Matrix c, int startI, int endI, int startJ, int endJ) {
        A = a;
        B = b;
        C = c;
        this.startI = startI;
        this.endI = endI;
        this.startJ = startJ;
        this.endJ = endJ;
    }

    @Override
    public void run() {
        for (int i = startI; i < endI; i++)
            for (int j = startJ; j < endJ; j++)
                for (int k = 0; k < A.N; k++)
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
    }
}

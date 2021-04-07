package TD3;

/******************************************************************************
 *  Compilation:  javac Matrix.java
 *  Execution:    java Matrix
 *                  https://introcs.cs.princeton.edu/java/95linear/Matrix.java
 *  A bare-bones immutable data type for M-by-N matrices.
 *
 ******************************************************************************/

final public class Matrix {
    public final int M;             // number of rows
    public final int N;             // number of columns
    public final double[][] data;   // M-by-N array

    // create M-by-N matrix of 0's
    public Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        data = new double[M][N];
    }

    // create matrix based on 2d array
    public Matrix(double[][] data) {
        M = data.length;
        N = data[0].length;
        this.data = new double[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                this.data[i][j] = data[i][j];
    }

    // copy constructor
    private Matrix(Matrix A) { this(A.data); }

    // create and return a random M-by-N matrix with values between 0 and 1
    public static Matrix random(int M, int N) {
        Matrix A = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.data[i][j] = Math.random();
        return A;
    }

    // create and return the N-by-N identity matrix
    public static Matrix identity(int N) {
        Matrix I = new Matrix(N, N);
        for (int i = 0; i < N; i++)
            I.data[i][i] = 1;
        return I;
    }

    // swap rows i and j
    private void swap(int i, int j) {
        double[] temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // create and return the transpose of the invoking matrix
    public Matrix transpose() {
        Matrix A = new Matrix(N, M);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.data[j][i] = this.data[i][j];
        return A;
    }

    // return C = A + B
    public Matrix plus(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] + B.data[i][j];
        return C;
    }


    // return C = A - B
    public Matrix minus(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] - B.data[i][j];
        return C;
    }

    // does A = B exactly?
    public boolean eq(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (A.data[i][j] != B.data[i][j]) return false;
        return true;
    }

    // return C = A * B
    public Matrix times0(Matrix B) {
        Matrix A = this;
        if (A.N != B.M)
            throw new RuntimeException("Illegal matrix dimensions.");

        Matrix C = new Matrix(A.M, B.N);
        long t = System.currentTimeMillis();
        for (int i = 0; i < C.M; i++)
            for (int j = 0; j < C.N; j++)
                for (int k = 0; k < A.N; k++)
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
        System.out.println("temps0 : " + (System.currentTimeMillis() - t) + "ms");
        return C;
    }

    // Avec 4 Thread
    public Matrix times1(Matrix B) {
        Matrix A = this;
        if (A.N != B.M)
            throw new RuntimeException("Illegal matrix dimensions.");

        Matrix C = new Matrix(A.M, B.N);

        int x = (int)(C.M / 2);
        int y = (int)(C.N / 2);

        long t = System.currentTimeMillis();

        Thread thread = new Thread() {
            public void run() {
                // HG
                for (int i = 0; i < x; i++)
                    for (int j = 0; j < y; j++)
                        for (int k = 0; k < A.N; k++)
                            C.data[i][j] += (A.data[i][k] * B.data[k][j]);
            }};

        Thread thread1 = new Thread() {
            public void run() {
                // HD
                //calculPartie(A, B, C, 0, x, y, C.N);
                for (int i = 0; i < x; i++)
                    for (int j = y; j < C.N; j++)
                        for (int k = 0; k < A.N; k++)
                            C.data[i][j] += (A.data[i][k] * B.data[k][j]);

            }};

        Thread thread2 = new Thread() {
            public void run() {
                // BD
                //calculPartie(A, B, C, x, C.M, y, C.N);
                for (int i = x; i < C.M; i++)
                    for (int j = y; j < C.N; j++)
                        for (int k = 0; k < A.N; k++)
                            C.data[i][j] += (A.data[i][k] * B.data[k][j]);

            }};

        Thread thread3 = new Thread() {
            public void run() {
                // BG
                //calculPartie(A, B, C, x, C.M, 0, y);
                for (int i = x; i < C.M; i++)
                    for (int j = 0; j < y; j++)
                        for (int k = 0; k < A.N; k++)
                            C.data[i][j] += (A.data[i][k] * B.data[k][j]);
            }};


        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();

        while (thread.isAlive() && thread1.isAlive() && thread2.isAlive() && thread3.isAlive()) {}
        System.out.println("temps1 : " + (System.currentTimeMillis() - t) + "ms");

        return C;
    }

    // Avec fonction générique
    public Matrix times2 (Matrix B) {
        Matrix A = this;
        if (A.N != B.M)
            throw new RuntimeException("Illegal matrix dimensions.");

        Matrix C = new Matrix(A.M, B.N);

        int x = (int)(C.M / 2);
        int y = (int)(C.N / 2);

        long t = System.currentTimeMillis();

        Thread thread = new Thread(()-> calculPartie(A, B, C, 0, x, 0, y));
        Thread thread1 = new Thread(()-> calculPartie(A, B, C, 0, x, y, C.N));
        Thread thread2 = new Thread(()-> calculPartie(A, B, C, x, C.M, y, C.N));
        Thread thread3 = new Thread(()-> calculPartie(A, B, C, x, C.M, 0, y));

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();

        while (thread.isAlive() && thread1.isAlive() && thread2.isAlive() && thread3.isAlive()) {}
        System.out.println("temps2 : " + (System.currentTimeMillis() - t) + "ms");

        return C;
    }

    // Avec classe Runable
    public Matrix times3 (Matrix B) {
        Matrix A = this;
        if (A.N != B.M)
            throw new RuntimeException("Illegal matrix dimensions.");

        Matrix C = new Matrix(A.M, B.N);

        int x = (int)(C.M / 2);
        int y = (int)(C.N / 2);

        long t = System.currentTimeMillis();

        Thread thread = new Thread(new MatrixActivite(A, B, C, 0, x, 0, y));
        Thread thread1 = new Thread(new MatrixActivite(A, B, C, 0, x, y, C.N));
        Thread thread2 = new Thread(new MatrixActivite(A, B, C, x, C.M, y, C.N));
        Thread thread3 = new Thread(new MatrixActivite(A, B, C, x, C.M, 0, y));

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();

        while (thread.isAlive() && thread1.isAlive() && thread2.isAlive() && thread3.isAlive()) {}
        System.out.println("temps3 : " + (System.currentTimeMillis() - t) + "ms");

        return C;
    }

    public void calculPartie (Matrix A, Matrix B, Matrix C, int startI, int endI, int startJ, int endJ) {
        for (int i = startI; i < endI; i++)
            for (int j = startJ; j < endJ; j++)
                for (int k = 0; k < A.N; k++)
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
    }

    // print matrix to standard output
    public void show() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                System.out.printf("%9.4f ", data[i][j]);
            System.out.println();
        }
    }

    // print complexity of the multiplication to standard output
    static public void showComp() {
        //System.out.print(" Multiplications :  " + Matrix.complexity);
        System.out.println();
    }

    // test client
    public static void main(String[] args) {

        Matrix A = Matrix.random(1500, 1000);
        //A.show();
        System.out.println();

        Matrix B = Matrix.random(1000, 2000);
        //B.show();
        System.out.println();


        //A.times0(B);  // 21837ms
        A.times1(B);    // 6616ms
        A.times2(B);    // 6018ms
        A.times3(B);    // 6571ms


        /*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(C.eq(D));
         */


        Matrix.showComp();
        System.out.println();
    }
}

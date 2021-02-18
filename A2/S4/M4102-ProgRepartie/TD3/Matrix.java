//package TD3;
//
///******************************************************************************
// *  Compilation:  javac Matrix.java
// *  Execution:    java Matrix
// *                  https://introcs.cs.princeton.edu/java/95linear/Matrix.java
// *  A bare-bones immutable data type for M-by-N matrices.
// *
// ******************************************************************************/
//
//final public class Matrix {
//    private final int M;             // number of rows
//    private final int N;             // number of columns
//    private final double[][] data;   // M-by-N array
//
//    // create M-by-N matrix of 0's
//    public Matrix(int M, int N) {
//        this.M = M;
//        this.N = N;
//        data = new double[M][N];
//    }
//
//    // create matrix based on 2d array
//    public Matrix(double[][] data) {
//        M = data.length;
//        N = data[0].length;
//        this.data = new double[M][N];
//        for (int i = 0; i < M; i++)
//            for (int j = 0; j < N; j++)
//                    this.data[i][j] = data[i][j];
//    }
//
//    // copy constructor
//    private Matrix(Matrix A) { this(A.data); }
//
//    // create and return a random M-by-N matrix with values between 0 and 1
//    public static Matrix random(int M, int N) {
//        Matrix A = new Matrix(M, N);
//        for (int i = 0; i < M; i++)
//            for (int j = 0; j < N; j++)
//                A.data[i][j] = Math.random();
//        return A;
//    }
//
//    // create and return the N-by-N identity matrix
//    public static Matrix identity(int N) {
//        Matrix I = new Matrix(N, N);
//        for (int i = 0; i < N; i++)
//            I.data[i][i] = 1;
//        return I;
//    }
//
//    // swap rows i and j
//    private void swap(int i, int j) {
//        double[] temp = data[i];
//        data[i] = data[j];
//        data[j] = temp;
//    }
//
//    // create and return the transpose of the invoking matrix
//    public Matrix transpose() {
//        Matrix A = new Matrix(N, M);
//        for (int i = 0; i < M; i++)
//            for (int j = 0; j < N; j++)
//                A.data[j][i] = this.data[i][j];
//        return A;
//    }
//
//    // return C = A + B
//    public Matrix plus(Matrix B) {
//        Matrix A = this;
//        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
//        Matrix C = new Matrix(M, N);
//        for (int i = 0; i < M; i++)
//            for (int j = 0; j < N; j++)
//                C.data[i][j] = A.data[i][j] + B.data[i][j];
//        return C;
//    }
//
//
//    // return C = A - B
//    public Matrix minus(Matrix B) {
//        Matrix A = this;
//        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
//        Matrix C = new Matrix(M, N);
//        for (int i = 0; i < M; i++)
//            for (int j = 0; j < N; j++)
//                C.data[i][j] = A.data[i][j] - B.data[i][j];
//        return C;
//    }
//
//    // does A = B exactly?
//    public boolean eq(Matrix B) {
//        Matrix A = this;
//        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
//        for (int i = 0; i < M; i++)
//            for (int j = 0; j < N; j++)
//                if (A.data[i][j] != B.data[i][j]) return false;
//        return true;
//    }
//
//    // return C = A * B
//    public Matrix times(Matrix B) {
/////////////////
// // TO DO
//////////////////
//    }
//
//    // print matrix to standard output
//    public void show() {
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++)
//                 System.out.printf("%9.4f ", data[i][j]);
//             System.out.println();
//        }
//    }
//
//   // print complexity of the multiplication to standard output
//    static public void showComp() {
//                 System.out.print(" Multiplications :  " + Matrix.complexity);
//             System.out.println();
//    }
//
//    // test client
//    public static void main(String[] args) {
//
//        Matrix A = Matrix.random(15, 10);
//        A.show();
//        StdOut.println();
//
//	Matrix B = Matrix.random(10, 20);
//        b.show();
//        StdOut.println();
//
// 	Matrix C = A.times(B);
//        C.show();
//         System.out.println();
//
//       Matrix.showComp();
//         System.out.println();
//    }
//}

package fr.umontpellier.iut.partie1;

public class App {
    public static void main(String[] args) {

        int mat [][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        Taquin t1 = new Taquin(mat);

        Contexte c1 = new Contexte(t1);

        c1.resoudre();
        System.out.println(c1);

    }
}

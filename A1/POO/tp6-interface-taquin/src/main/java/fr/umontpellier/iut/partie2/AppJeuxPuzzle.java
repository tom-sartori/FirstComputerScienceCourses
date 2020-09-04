package fr.umontpellier.iut.partie2;

public class AppJeuxPuzzle {
    public static void main(String[] args) {

        int [][] tab = {{2, 1, 0}};

        JeuPuzzle j1 = new Taquin(tab);
        Contexte c2 = new Contexte(j1);
        c2.resoudre();

        System.out.println(c2);

        JeuPuzzle j2 = new Hanoi(1);
        Contexte c3 = new Contexte(j2);
        c3.resoudre();

        System.out.println(c3);
    }
}

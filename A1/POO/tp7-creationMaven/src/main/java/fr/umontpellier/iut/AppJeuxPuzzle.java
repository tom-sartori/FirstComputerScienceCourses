package fr.umontpellier.iut;

public class AppJeuxPuzzle {
    public static void main(String[] args) {

        int [][] tab = {{1, 2, 0}};

        JeuPuzzle j1 = new Taquin(tab);
        Contexte c2 = new Contexte(j1);
        c2.resoudre();

        System.out.println(c2);

        JeuPuzzle j2 = new Hanoi(10);
        Contexte c3 = new Contexte(j2);
        c3.resoudre();

        System.out.println(c3);
    }
}

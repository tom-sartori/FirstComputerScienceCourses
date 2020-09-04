package fr.umontpellier.iut.partie2;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("Duplicates")

public class Taquin implements JeuPuzzle{
    private int[][] tableau;

    public Taquin(int[][] tableau) {
        this.tableau = tableau;
    }

    public Taquin (Taquin taquin) {
        int n = taquin.tableau.length;
        int m = taquin.tableau[0].length;

        int [][] tab = new int [n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tab[i][j] = taquin.tableau[i][j];
            }
        }
        this.tableau = tab;
    }


    @Override
    public String toString() {
        int n, m;
        StringBuilder ch = new StringBuilder();

        n = tableau.length;
        m = tableau[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                ch.append(tableau[i][j]).append(" ");
            ch.append("\n");
        }

        /* code prof
        for (int [] ligne : tableau)
            ch += Arrays.toString(ligne) + "\n";
         */

        return ch.toString();
    }


    public boolean estGagnant() {
        int n = tableau.length;
        int m = tableau[0].length;
        int x = 1;

        if (tableau[n - 1][m - 1] == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == n - 1 && j == m - 1)
                        return true;
                    if (tableau[i][j] != x)
                        return false;
                    x++;
                }
            }
        } else
            return false;
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taquin taquin = (Taquin) o;

        return Arrays.deepEquals(tableau, taquin.tableau);
    }


    @Override
    public int hashCode() {
        return Arrays.deepHashCode(tableau);
    }


    public ArrayList<JeuPuzzle> genererFils() {
        int [] tab = trouverTrou();
        int i = tab[0], j = tab [1];
        int n = tableau.length, m = tableau[0].length;
        Taquin t;
        ArrayList<JeuPuzzle> listeTaquin = new ArrayList<>();

        if (i > 0) {
            t = new Taquin(this);
            t.tableau[i][j] = t.tableau[i-1][j];
            t.tableau[i-1][j] = 0;
            listeTaquin.add(t);
        }
        if (i < n-1) {
            t = new Taquin(this);
            t.tableau[i][j] = t.tableau [i+1][j];
            t.tableau[i+1][j] = 0;
            listeTaquin.add(t);
        }
        if (j > 0) {
            t = new Taquin(this);
            t.tableau[i][j] = t.tableau [i][j-1];
            t.tableau[i][j-1] = 0;
            listeTaquin.add(t);
        }
        if (j < m-1) {
            t = new Taquin(this);
            t.tableau[i][j] = t.tableau [i][j+1];
            t.tableau[i][j+1] = 0;
            listeTaquin.add(t);
        }
        return listeTaquin;
    }


    //retourne un tableau [i,j] si tableau[i][j]==0
    public int[] trouverTrou() {
        int n = tableau.length;
        int m = tableau[0].length;
        int tab[] = new int[2];

        boolean trouve = false;

        int i = 0;

        while (i < n && !trouve) {
            int j = 0;
            while (j < m && !trouve) {
                if (tableau[i][j] == 0) {
                    trouve = true;
                    tab[0] = i;
                    tab[1] = j;
                }
                j++;
            }
            i++;
        }
        return tab;

    }
}

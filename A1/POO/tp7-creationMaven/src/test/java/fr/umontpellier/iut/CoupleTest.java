package fr.umontpellier.iut;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoupleTest {

    @Test
    public void test_couple_getListeDeMouvements() {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Taquin taquin1 = new Taquin(data1);

        int[][] data2 = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        Taquin taquin2 = new Taquin(data2);

        Couple couple2 = new Couple(taquin2, null);
        Couple couple1 = new Couple(taquin1, couple2);

        ArrayList<JeuPuzzle> res = couple1.getListeDeMouvements();
        ArrayList<Taquin> res2 = new ArrayList<>();
        res2.add(taquin2);
        res2.add(taquin1);
        assertEquals(res, res2);
    }

    @Test
    public void test_couple_getListeDeMouvements_null() {
        Taquin taquin1 = null;

        Couple couple1 = new Couple(taquin1, null);

        ArrayList<JeuPuzzle> res = couple1.getListeDeMouvements();
        ArrayList<Taquin> res2 = new ArrayList<>();
        assertEquals(res2, res);
    }

    @Test
    public void test_couple_getListeDeMouvements_vide() {
        int [][] data1 = {{}};
        Taquin taquin1 = new Taquin(data1);

        Couple couple1 = new Couple(taquin1, null);

        ArrayList<JeuPuzzle> res = couple1.getListeDeMouvements();
        ArrayList<Taquin> res2 = new ArrayList<>();
        res2.add(taquin1);
        assertEquals(res2, res);
    }
}
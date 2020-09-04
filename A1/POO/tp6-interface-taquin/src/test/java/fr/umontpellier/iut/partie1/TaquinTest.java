package fr.umontpellier.iut.partie1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaquinTest {

//Tests estGagnant
    @Test
    public void test_est_gagnant_faux_3_X_3() {
        int[][] data = {{1, 2, 0}, {4, 5, 3}, {7, 8, 6}};
        Taquin t = new Taquin(data);
        assertFalse(t.estGagnant());
    }
    @Test
    public void test_faux_mauvais_ordre() {
        int[][] data = {{1, 2, 3}, {4, 5, 3}, {7, 8, 6}};
        Taquin t = new Taquin(data);
        assertFalse(t.estGagnant());
    }

    @Test
    public void test_faux_mauvais_ordre_0_fin() {
        int[][] data = {{1, 2, 0}, {4, 5, 3}, {7, 8, 0}};
        Taquin t = new Taquin(data);
        assertFalse(t.estGagnant());
    }

    @Test
    public void test_est_faux_pas_0() {
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Taquin t = new Taquin(data);
        assertFalse(t.estGagnant());
    }

    @Test
    public void test_bon_3x3() {
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Taquin t = new Taquin(data);
        assertTrue(t.estGagnant());
    }

    @Test
    public void test_bon_3x2() {
        int[][] data = {{1, 2, 3}, {4, 5, 0}};
        Taquin t = new Taquin(data);
        assertTrue(t.estGagnant());
    }

    @Test
    public void test_bon_00() {
        int[][] data = {{0}};
        Taquin t = new Taquin(data);
        assertTrue(t.estGagnant());
    }

    @Test
    public void test_bon_1_0() {
        int[][] data = {{1}, {0}};
        Taquin t = new Taquin(data);
        assertTrue(t.estGagnant());
    }


//Tests equals

    @Test
    public void test_pas_egale () {
        int [][] data = {{1, 2, 3}, {4, 5, 6}};
        Taquin t1 = new Taquin(data);

        int [][] data2 = {{1, 2, 4}, {6, 5, 6}};
        Taquin t2 = new Taquin(data2);

        assertFalse(t1.equals(t2));
    }

    @Test
    public void test_est_egale () {
        int [][] data = {{1, 2, 3}, {4, 5, 6}};
        Taquin t1 = new Taquin(data);

        int [][] data2 = {{1, 2, 3}, {4, 5, 6}};
        Taquin t2 = new Taquin(data2);

        assertTrue(t1.equals(t2));
    }

    @Test
    public void test_est_egale_hashCode () {
        int [][] data = {{1, 2, 3}, {4, 5, 6}};
        Taquin t1 = new Taquin(data);

        int [][] data2 = {{1, 2, 3}, {4, 5, 6}};
        Taquin t2 = new Taquin(data2);

        assertEquals(t1.hashCode(), t2.hashCode());
    }



    @Test
    public void test_trouver_trou_coin_hd_3_X_3() {
        int[][] data = {{1, 2, 0}, {4, 5, 3}, {7, 8, 6}};
        Taquin t = new Taquin(data);
        int[] res = t.trouverTrou();
        int[] res2 = {0, 2};
        assertArrayEquals(res2, res);
    }

    @Test
    public void test_trouver_3x3_0_0() {
        int[][] data = {{0, 2, 1}, {4, 5, 3}, {7, 8, 6}};
        Taquin t = new Taquin(data);
        int[] res = t.trouverTrou();
        int[] res2 = {0, 0};
        assertArrayEquals(res2, res);
    }

    @Test
    public void test_trouver_5x3_4_2() {
        int[][] data = {{3, 2, 1}, {4, 5, 3}, {7, 8, 6}, {17, 18, 19}, {11, 12, 0}};
        Taquin t = new Taquin(data);
        int[] res = t.trouverTrou();
        int[] res2 = {4, 2};
        assertArrayEquals(res2, res);
    }

    @Test
    public void test_trouver_1x1_0_0() {
        int[][] data = {{0, 2, 1}, {4, 5, 3}, {7, 8, 6}, {11, 12, }};
        Taquin t = new Taquin(data);
        int[] res = t.trouverTrou();
        int[] res2 = {0, 0};
        assertArrayEquals(res2, res);
    }

    @Test
    public void test_trouver_1x1_0() {
        int[][] data = {{0}};
        Taquin t = new Taquin(data);
        int[] res = t.trouverTrou();
        int[] res2 = {0, 0};
        assertArrayEquals(res2, res);
    }



    @Test
    public void test_equals_vrai_3_X_3() {
        int[][] data = {{1, 2, 0}, {4, 5, 3}, {7, 8, 6}};
        Taquin t = new Taquin(data);
        int[][] data2 = {{1, 2, 0}, {4, 5, 3}, {7, 8, 6}};
        Taquin t2 = new Taquin(data2);
        assertEquals(t, t2);
    }

    @Test
    public void test_construct () {
        int [][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Taquin t1 = new Taquin(data);
        Taquin t2 = new Taquin(t1);
        assertTrue(t1.equals(t2));
    }


    @Test
    public void test_generer_Fils_coin_3_X_3() {
        int[][] data = {{1, 2, 0}, {4, 5, 3}, {7, 8, 6}};
        Taquin t = new Taquin(data);
        ArrayList<Taquin> res = t.genererFils();
        ArrayList<Taquin> res2 = new ArrayList<>();
        int[][] datafils1 = {{1, 2, 3}, {4, 5, 0}, {7, 8, 6}};
        Taquin fils1 = new Taquin(datafils1);
        int[][] datafils2 = {{1, 0, 2}, {4, 5, 3}, {7, 8, 6}};
        Taquin fils2 = new Taquin(datafils2);
        res2.add(fils1);
        res2.add(fils2);
        assertTrue(res.containsAll(res2) && res2.containsAll(res));
    }

    @Test
    public void test_generer_Fils_milieu_3_X_3() {
        int[][] data = {{1, 2, 3}, {4, 0, 5}, {6, 7, 8}};
        Taquin t = new Taquin(data);
        ArrayList<Taquin> res = t.genererFils();
        ArrayList<Taquin> res2 = new ArrayList<>();
        int[][] datafils1 = {{1, 0, 3}, {4, 2, 5}, {6, 7, 8}};
        Taquin fils1 = new Taquin(datafils1);
        int[][] datafils2 = {{1, 2, 3}, {4, 5, 0}, {6, 7, 8}};
        Taquin fils2 = new Taquin(datafils2);
        int[][] datafils3 = {{1, 2, 3}, {4, 7, 5}, {6, 0, 8}};
        Taquin fils3 = new Taquin(datafils3);
        int[][] datafils4 = {{1, 2, 3}, {0, 4, 5}, {6, 7, 8}};
        Taquin fils4 = new Taquin(datafils4);
        res2.add(fils1);
        res2.add(fils2);
        res2.add(fils3);
        res2.add(fils4);
        assertTrue(res.containsAll(res2) && res2.containsAll(res));
    }

    @Test
    public void test_generer_Fils_coin_bas_gauche_3_X_3() {
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {0, 7, 8}};
        Taquin t = new Taquin(data);
        ArrayList<Taquin> res = t.genererFils();
        ArrayList<Taquin> res2 = new ArrayList<>();
        int[][] datafils1 = {{1, 2, 3}, {0, 5, 6}, {4, 7, 8}};
        Taquin fils1 = new Taquin(datafils1);
        int[][] datafils2 = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        Taquin fils2 = new Taquin(datafils2);
        res2.add(fils1);
        res2.add(fils2);
        assertTrue(res.containsAll(res2) && res2.containsAll(res));
    }

    @Test
    public void test_generer_Fils_0() {
        int[][] data = {{0}};
        Taquin t = new Taquin(data);
        ArrayList<Taquin> res = t.genererFils();
        ArrayList<Taquin> res2 = new ArrayList<>();
        assertTrue(res.containsAll(res2) && res2.containsAll(res));
    }

    @Test
    public void test_generer_Fils_01() {
        int[][] data = {{0, 1}};
        Taquin t = new Taquin(data);
        ArrayList<Taquin> res = t.genererFils();
        ArrayList<Taquin> res2 = new ArrayList<>();
        int[][] datafils1 = {{1, 0}};
        Taquin fils1 = new Taquin(datafils1);
        res2.add(fils1);
        assertTrue(res.containsAll(res2) && res2.containsAll(res));
    }
}
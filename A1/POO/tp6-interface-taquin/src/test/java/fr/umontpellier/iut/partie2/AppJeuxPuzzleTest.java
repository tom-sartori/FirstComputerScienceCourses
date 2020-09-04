package fr.umontpellier.iut.partie2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppJeuxPuzzleTest {

    @Test
    public void test_if_main_method_was_implemented() {
        assertDoesNotThrow(() -> AppJeuxPuzzle.main(new String[1]));
    }

    @Test
    public void test_Hanoi_3 () {
        JeuPuzzle jeuPuzzle = new Hanoi(3);
        Contexte contexte = new Contexte(jeuPuzzle);
        contexte.resoudre();
        assertFalse(contexte.getSolution().isEmpty());
    }

    @Test
    public void test_Hanoi_0 () {
        JeuPuzzle jeuPuzzle = new Hanoi(0);
        Contexte contexte = new Contexte(jeuPuzzle);
        contexte.resoudre();
        assertFalse(contexte.getSolution().isEmpty());
    }

    @Test
    public void test_Hanoi_comparaison () {
        JeuPuzzle jeuPuzzle = new Hanoi(12);
        Contexte contexte = new Contexte(jeuPuzzle);
        contexte.resoudre();
        System.out.println(contexte);
        assertFalse(contexte.getSolution().isEmpty());
    }
}
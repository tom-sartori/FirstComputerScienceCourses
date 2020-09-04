package fr.umontpellier.iut;

import org.junit.jupiter.api.Test;

class HanoiTest {

    @Test
    public void test () {
        JeuPuzzle hanoi = new Hanoi(3);
        Contexte contexte = new Contexte(hanoi);
        contexte.resoudre();
    }

}
package fr.umontpellier.iut.partie2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HanoiTest {

    @Test
    public void test () {
        JeuPuzzle hanoi = new Hanoi(3);
        Contexte contexte = new Contexte(hanoi);
        contexte.resoudre();
    }

}
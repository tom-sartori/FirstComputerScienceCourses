package fr.umontpellier.iut.expressions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NombreTest {

    @Test
    public void calculerValeur_0() {
        assertEquals(0, new Nombre(0).calculerValeur());
    }
}
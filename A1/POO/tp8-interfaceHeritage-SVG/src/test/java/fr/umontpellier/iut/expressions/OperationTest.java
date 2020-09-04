package fr.umontpellier.iut.expressions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperationTest {

    @Test
    void calculerValeur_10_fois_5() {
        Expression e = new Operation('*', new Nombre(10), new Nombre(5));
        System.out.println(e);
        assertEquals(50, e.calculerValeur());
    }

    @Test
    void calculerValeur_10_plus_5() {
        Expression expression = new Operation('+', new Nombre(10), new Nombre(5));
        assertEquals(15, expression.calculerValeur());
    }

    @Test
    void calculerValeur_10_moins_5() {
        Expression expression = new Operation('-', new Nombre(10), new Nombre(5));
        assertEquals(5, expression.calculerValeur());
    }

    @Test
    void calculerValeur_10_div_5() {
        Expression expression = new Operation('/', new Nombre(10), new Nombre(5));
        assertEquals(2, expression.calculerValeur());
    }

    @Test
    void calculerValeur_10_plus_moins_5() {
        Expression expression = new Operation('+', new Nombre(10), new Nombre(-5));
        assertEquals(5, expression.calculerValeur());
    }

    @Test
    void calculerValeur_moins_10_fois_moins_5() {
        Expression expression = new Operation('*', new Nombre(-10), new Nombre(-5));
        assertEquals(50, expression.calculerValeur());
    }

    @Test
    void calculerValeur_10_div_0() {
        Expression expression = new Operation('/', new Nombre(10), new Nombre(0));
        assertEquals(0, expression.calculerValeur());
    }

    @Test
    void calculerValeur_3_plus_5_fois_2() {
        Expression e1 = new Operation('*', new Nombre(5), new Nombre(2));
        Expression e2 = new Operation('+', new Nombre(3), e1);
        System.out.println(e2);
        assertEquals(13, e2.calculerValeur());
    }
}

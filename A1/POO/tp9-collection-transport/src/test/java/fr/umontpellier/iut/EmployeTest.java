package fr.umontpellier.iut;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeTest {
    @Test
    public void test_Employe_doublon () {
        Employe employe = new Employe("111", "AAA", 20);
        Employe employe1 = new Employe("111", "AAA", 50);
        assertTrue(employe.compareTo(employe1) == 0);
    }

    @Test
    public void test_Employe_memeNom () {
        Employe employe = new Employe("111", "AAA", 20);
        Employe employe1 = new Employe("222", "AAA", 20);
        assertTrue(employe.compareTo(employe1) > 0);
    }

    @Test
    public void test_Anciennete () {
        Employe employe = new Employe("111", "Dupont", 20);
        Employe employe1 = new Employe("222", "Martin", 20);

        employe.setDateEmbauche(LocalDate.of(2020, 1, 5));
        employe1.setDateEmbauche(LocalDate.of(2020, 1, 15));

        assertEquals(employe.getMoisAnciennete(), employe1.getMoisAnciennete());
    }

    @Test
    public void test_indemnite_0 () {
        Employe employe = new Employe("111", "Pac", 20);
        employe.setAdresse("Montpellier");
        assertEquals(0, employe.getIndemniteTransport());
    }

    @Test
    public void test_indemnite_1 () {
        Employe employe = new Employe("111", "Pac", 20);
        employe.setAdresse("Nîmes");
        assertEquals(1160, employe.getIndemniteTransport());
    }
}
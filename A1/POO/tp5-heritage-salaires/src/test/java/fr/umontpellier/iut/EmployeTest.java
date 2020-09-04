package fr.umontpellier.iut;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeTest {

    @Test
    public void test_avec_employe_null () {
        Employe employe = new EmployeBuilder()
                .createEmploye();

        assertEquals(0, employe.getSalaireBrut());
        assertEquals(0, employe.getSalaireNet());
    }

    @Test
    public void test_avec_base_null () {
        Employe employe = new EmployeBuilder()
                .setNbHeures(100)
                .createEmploye();

        assertEquals(0, employe.getSalaireNet());
    }

    @Test
    public void test_avec_nbHeures_null () {
        Employe employe = new EmployeBuilder()
                .setBase(12)
                .createEmploye();

        assertEquals(0, employe.getSalaireNet());
    }

    @Test
    public void test_cas_normal_entiers () {
        Employe employe = new EmployeBuilder()
                .setBase(10)
                .setNbHeures(50)
                .createEmploye();

        assertEquals(500, employe.getSalaireBrut());
        assertEquals(400, employe.getSalaireNet());
    }

    @Test
    public void test_cas_normal_flottants () {
        Employe employe = new EmployeBuilder()
                .setNbHeures(75.5)
                .setBase(31.42)
                .createEmploye();

        assertEquals(2372.21, employe.getSalaireBrut());
        assertEquals(1897.768, employe.getSalaireNet());
    }
}
package fr.umontpellier.iut;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class EntrepriseTest {

    @Test
    public void test_Entreprise_taille () {
        Entreprise entreprise = new Entreprise();

        Employe employe = new Employe("111", "AAA", 20);
        Employe employe1 = new Employe("333", "EEE", 20);
        Employe employe2 = new Employe("111", "AAA", 20);
        Employe employe3 = new Employe("888", "AAA", 20);
        Employe employe4 = new Employe("555", "FFF", 20);

        entreprise.embaucher(employe, LocalDate.now());
        entreprise.embaucher(employe1, LocalDate.now());
        entreprise.embaucher(employe2, LocalDate.now());
        entreprise.embaucher(employe3, LocalDate.now());
        entreprise.embaucher(employe4, LocalDate.now());

        assertTrue(entreprise.getEmployesDansDesordre().size() == entreprise.getEmployesOrdonnes().size());
    }

    @Test
    public void test_Entreprise_content () {
        Entreprise entreprise = new Entreprise();

        Employe employe = new Employe("111", "AAA", 20);
        Employe employe1 = new Employe("333", "EEE", 20);
        Employe employe2 = new Employe("111", "AAA", 20);
        Employe employe3 = new Employe("888", "AAA", 20);
        Employe employe4 = new Employe("555", "FFF", 20);

        entreprise.embaucher(employe, LocalDate.now());
        entreprise.embaucher(employe1, LocalDate.now());
        entreprise.embaucher(employe2, LocalDate.now());
        entreprise.embaucher(employe3, LocalDate.now());
        entreprise.embaucher(employe4, LocalDate.now());

        System.out.println(entreprise.getEmployesOrdonnes());

        assertTrue(entreprise.getEmployesDansDesordre().equals(entreprise.getEmployesOrdonnes()));
    }

    @Test
    public void test_Entreprise_ordre () {
        Entreprise entreprise = new Entreprise();

        Employe employe = new Employe("111", "AAA", 20);
        Employe employe1 = new Employe("333", "EEE", 20);
        Employe employe2 = new Employe("111", "AAA", 20);
        Employe employe3 = new Employe("888", "AAA", 20);
        Employe employe4 = new Employe("555", "FFF", 20);

        entreprise.embaucher(employe, LocalDate.now());
        entreprise.embaucher(employe1, LocalDate.now());
        entreprise.embaucher(employe2, LocalDate.now());
        entreprise.embaucher(employe3, LocalDate.now());
        entreprise.embaucher(employe4, LocalDate.now());

        Collection<Employe> list = new TreeSet<>();
        list.add(employe3);
        list.add(employe);
        list.add(employe1);
        list.add(employe4);

        assertEquals(list.toString(), entreprise.getEmployesOrdonnes().toString());
    }

    @Test
    public void test_distriBonus_1 () {
        Entreprise entreprise = new Entreprise();

        Employe employe = new Employe("111", "AAA", 20);
        Employe employe1 = new Employe("333", "EEE", 20);
        Employe employe2 = new Employe("555", "FFF", 20);
        Employe employe3 = new Employe("111", "AAA", 30);
        Employe employe4 = new Employe("777", "BBB", 20);

        entreprise.embaucher(employe, LocalDate.of(2020, 1, 1));
        entreprise.embaucher(employe1, LocalDate.of(2020, 2, 1));
        entreprise.embaucher(employe2, LocalDate.of(2020, 3, 1));
        entreprise.embaucher(employe3, LocalDate.of(2020, 3, 15));
        entreprise.embaucher(employe4, LocalDate.of(2020, 3, 20));

        entreprise.setBonusTotal(16);
        entreprise.distribuerBonus();

        assertEquals(9, employe.getBonus());
        assertEquals(6, employe1.getBonus());
        assertEquals(1, employe2.getBonus());
        assertEquals(0, employe3.getBonus());
        assertEquals(0, employe4.getBonus());
    }

    @Test
    public void test_remercier_1 () {
        Entreprise entreprise = new Entreprise();

        Employe employe = new Employe("111", "AAA", 20);
        Employe employe1 = new Employe("333", "EEE", 20);
        Employe employe2 = new Employe("555", "FFF", 20);
        Employe employe3 = new Employe("111", "AAA", 30);
        Employe employe4 = new Employe("777", "BBB", 20);

        entreprise.embaucher(employe, LocalDate.of(2020, 1, 1));
        entreprise.embaucher(employe1, LocalDate.of(2020, 2, 1));
        entreprise.embaucher(employe2, LocalDate.of(2020, 3, 1));
        entreprise.embaucher(employe3, LocalDate.of(2020, 2, 15));
        entreprise.embaucher(employe4, LocalDate.of(2020, 1, 20));

        entreprise.remercier(2);


        Entreprise entreprise1 = new Entreprise();
        entreprise1.embaucher(employe, LocalDate.of(2020, 1, 1));
        entreprise1.embaucher(employe1, LocalDate.of(2020, 2, 1));
        entreprise1.embaucher(employe4, LocalDate.of(2020, 1, 20));


        assertEquals(entreprise1.getEmployesOrdonnes(), entreprise.getEmployesOrdonnes());
    }
}
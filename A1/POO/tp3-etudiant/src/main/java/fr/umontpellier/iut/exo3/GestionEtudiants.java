package fr.umontpellier.iut.exo3;

import java.time.LocalDate;

public class GestionEtudiants {
    public static void main(String[] args) {

        EtudiantTelescopique e1 = new EtudiantTelescopique("Poutine", "Vlad");

        EtudiantTelescopique e2 = new EtudiantTelescopique("Prevert", "Jacques", LocalDate.of(1999, 1, 15));

        EtudiantTelescopique e3 = new EtudiantTelescopique("Prevert", "Jacques", "J.J@gmail.com");

        System.out.println(e1);
    }
}

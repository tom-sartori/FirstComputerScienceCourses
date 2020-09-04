package fr.umontpellier.iut.exo1;

import java.time.LocalDate;

public class GestionEtudiants {
    public static void main(String[] args) {

        Etudiant lolo = new Etudiant("Dupont", "Jean", LocalDate.of(2000, 01, 05), "j.dupont@gmail.com", "20 rue de la foret");
        System.out.println(lolo.toString());

        // Etudiant toto = new Etudiant("Dupont", "Jean", LocalDate.of(2000, 01, 05), "j.dupont@gmail.com", "20 rue de la foret");

        Etudiant toto = lolo;

        System.out.println(lolo == toto);

        Departement monDepInfo = new Departement("Info", "3 Grand rue");

        System.out.println(monDepInfo);

        monDepInfo.inscrire(toto);
        monDepInfo.inscrire(lolo);

        System.out.println(monDepInfo);

        monDepInfo.desinscrire(toto);

        System.out.println(monDepInfo);
    }
}

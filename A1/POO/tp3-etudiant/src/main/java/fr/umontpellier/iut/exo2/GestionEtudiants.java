package fr.umontpellier.iut.exo2;

import java.time.LocalDate;

public class GestionEtudiants {
    public static void main(String[] args) {

        Etudiant e1 = new Etudiant("Dupont", "Jean", LocalDate.of(2000, 01, 05), "j.dupont@gmail.com", "20 rue de la foret");

        Professeur p1 = new Professeur("MJ", "Alain");
        Matiere m1 = new Matiere("Maths", 2, p1);

        Professeur p2 = new Professeur("Monod", "Jean");
        Matiere m2 = new Matiere("BD", 4.5, p2);

        Professeur p3 = new Professeur("Pays", "Jacques");
        Matiere m3 = new Matiere("Anglais", 2, p3);

        e1.noter(m1, 15.4);
        e1.noter(m2, 12);
        e1.noter(m3, 14);

        System.out.println("Moyenne de " + e1 + " est de : " + Math.round(e1.calculerMoyenne() *100.0) / 100.0);
    }
}

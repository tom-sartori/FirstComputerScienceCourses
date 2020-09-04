package fr.umontpellier.iut.exercice3;

import fr.umontpellier.iut.exercice1.Personne;

public class App {
    public static void main(String[] args) {

        Personne personne = new Personne("Marie");
        Personne personne1 = new Personne("Denise");

        SalleAttenteGenerique<Personne> salleAttente = new SalleAttenteGenerique();

        salleAttente.entrer(personne, 3);
        salleAttente.entrer(personne1, 1);

        System.out.println(salleAttente.sortir());
        System.out.println(salleAttente.sortir());
    }
}

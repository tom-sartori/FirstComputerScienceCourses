package fr.umontpellier.iut.exercice3bis;

import fr.umontpellier.iut.exercice1.Personne;
import fr.umontpellier.iut.exercice3.SalleAttenteGenerique;

public class App {
    public static void main(String[] args) {

        Personne personne = new Personne("Marie");
        Personne personne1 = new Personne("Denise");

        FilePriorite<Personne> file = new FilePriorite<>();
        file.ajouter(new ObjetPriorise<>(personne, 3));
        file.ajouter(new ObjetPriorise<>(personne1, 5));
        System.out.println(file.enlever());
    }
}

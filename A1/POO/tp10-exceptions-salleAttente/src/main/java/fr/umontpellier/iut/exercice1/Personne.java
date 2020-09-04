package fr.umontpellier.iut.exercice1;

public class Personne {
    private String nom;

    public Personne(String s) {
        nom = s;
    }

    @Override
    public String toString() {
        return nom;
    }
}
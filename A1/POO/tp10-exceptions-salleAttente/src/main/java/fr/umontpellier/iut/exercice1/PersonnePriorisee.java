package fr.umontpellier.iut.exercice1;

public class PersonnePriorisee implements TypePriorise {

    private Personne personne;
    private int priorite;

    public PersonnePriorisee(int priorite, Personne personne) {
        this.personne = personne;
        this.priorite = priorite;
    }

    @Override
    public String toString() {
        return "PersonnePriorisee{" +
                "personne=" + personne +
                ", priorite=" + priorite +
                '}';
    }

    public int getIndicePriorite() {
        return priorite;
    }
}

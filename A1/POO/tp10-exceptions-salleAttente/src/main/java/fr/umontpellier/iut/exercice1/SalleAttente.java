package fr.umontpellier.iut.exercice1;

public class SalleAttente {

    private FilePriorite salle;

    public SalleAttente() {
        salle = new FilePriorite();
    }

    public void entrer(Personne p, int priorite) {
        TypePriorise nouveau = new PersonnePriorisee(priorite, p);
        salle.ajouter(nouveau);
    }

    public String sortir() {
        return salle.enlever().toString();
    }
}

package fr.umontpellier.iut.exercice3;

import fr.umontpellier.iut.exercice1.FilePriorite;
import fr.umontpellier.iut.exercice1.TypePriorise;

public class SalleAttenteGenerique<T> {

    private FilePriorite salle;

    public SalleAttenteGenerique () {
        salle = new FilePriorite();
    }

    public void entrer (T item, int priorite) {
        TypePriorise nouveau = new ObjetPriorise<>(item, priorite);
        salle.ajouter(nouveau);
    }

    public String sortir () {
        return salle.enlever().toString();
    }
}

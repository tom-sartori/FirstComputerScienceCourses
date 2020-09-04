package fr.umontpellier.iut.exercice3bis;

import fr.umontpellier.iut.exercice1.TypePriorise;

import java.util.ArrayList;
import java.util.List;

public class FilePriorite<T> {

    private ArrayList<ObjetPriorise<T>> listTPriorise;

    public FilePriorite() {
        listTPriorise = new ArrayList<>();
    }

    public void ajouter (ObjetPriorise<T> d) {
        listTPriorise.add(d);
    }

    public ObjetPriorise<T> enlever() {
        if (listTPriorise.isEmpty())
            throw new ArrayIndexOutOfBoundsException("La liste est vide");

        ObjetPriorise<T> premier = listTPriorise.get(0);
        for (ObjetPriorise<T> courant : listTPriorise) {
            if (courant.getIndicePriorite() < premier.getIndicePriorite())
                premier = courant;
        }
        listTPriorise.remove(premier);
        return premier;
    }
}

package fr.umontpellier.iut.exercice1;

import java.util.ArrayList;
import java.util.List;

public class FilePriorite {

    private List<TypePriorise> listTPriorise;

    public FilePriorite() {
        listTPriorise = new ArrayList<>();
    }

    public void ajouter (TypePriorise d) {
        listTPriorise.add(d);
    }

    public TypePriorise enlever() {
        if (listTPriorise.isEmpty())
            throw new ArrayIndexOutOfBoundsException("La liste est vide");

        TypePriorise premier = listTPriorise.get(0);
        for (TypePriorise courant : listTPriorise) {
            if (courant.getIndicePriorite() < premier.getIndicePriorite())
                premier = courant;
        }
        listTPriorise.remove(premier);
        return premier;
    }
}

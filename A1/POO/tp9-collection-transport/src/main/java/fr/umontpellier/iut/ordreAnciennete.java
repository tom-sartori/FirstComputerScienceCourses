package fr.umontpellier.iut;

import java.util.Comparator;

public class ordreAnciennete implements Comparator <Employe> {

    @Override
    public int compare(Employe o1, Employe o2) {
        return o1.getDateEmbauche().compareTo(o2.getDateEmbauche());
    }
}

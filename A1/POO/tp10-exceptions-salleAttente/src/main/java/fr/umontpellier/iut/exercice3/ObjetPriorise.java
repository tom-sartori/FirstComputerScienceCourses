package fr.umontpellier.iut.exercice3;

import fr.umontpellier.iut.exercice1.TypePriorise;

public class ObjetPriorise<T> implements TypePriorise {

    private T item;
    private int priorite;


    public ObjetPriorise(T item, int priorite) {
        this.item = item;
        this.priorite = priorite;
    }

    @Override
    public String toString() {
        return "ObjetPriorise{" +
                "item=" + item +
                ", priorite=" + priorite +
                '}';
    }

    @Override
    public int getIndicePriorite() {
        return priorite;
    }
}

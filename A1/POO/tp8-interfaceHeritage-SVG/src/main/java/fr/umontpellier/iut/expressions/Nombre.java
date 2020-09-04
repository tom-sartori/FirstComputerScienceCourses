package fr.umontpellier.iut.expressions;

public class Nombre implements Expression {

    private double valeur;

    public Nombre(double valeur) {
        this.valeur = valeur;
    }

    @Override
    public double calculerValeur() {
        return this.valeur;
    }

    @Override
    public String toString() {
        return "" + valeur;
    }
}

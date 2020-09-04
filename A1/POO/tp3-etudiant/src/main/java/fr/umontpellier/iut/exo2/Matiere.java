package fr.umontpellier.iut.exo2;

public class Matiere {
    private String intitule;
    private double coef;
    private Professeur profResp;

    public Matiere(String intitule, double coef, Professeur profResp) {
        this.intitule = intitule;
        this.coef = coef;
        this.profResp = profResp;
    }

    public double getCoefficient () {
        return this.coef;
    }
}

package fr.umontpellier.iut;

public class EmployeBuilder {
    private String nrINSEE;
    private String nom;
    private int echelon;
    private double base;
    private double nbHeures;

    public EmployeBuilder setNrINSEE(String nrINSEE) {
        this.nrINSEE = nrINSEE;
        return this;
    }

    public EmployeBuilder setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public EmployeBuilder setEchelon(int echelon) {
        this.echelon = echelon;
        return this;
    }

    public EmployeBuilder setBase(double base) {
        this.base = base;
        return this;
    }

    public EmployeBuilder setNbHeures(double nbHeures) {
        this.nbHeures = nbHeures;
        return this;
    }

    public Employe createEmploye() {
        return new Employe(nrINSEE, nom, echelon, base, nbHeures);
    }
}
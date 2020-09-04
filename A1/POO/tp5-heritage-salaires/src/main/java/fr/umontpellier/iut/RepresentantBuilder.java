package fr.umontpellier.iut;

public class RepresentantBuilder {
    private String nrINSEE;
    private String nom;
    private int echelon;
    private double base;
    private double nbHeures;
    private double chiffreAffaires;
    private double tauxCommission;

    public RepresentantBuilder setNrINSEE(String nrINSEE) {
        this.nrINSEE = nrINSEE;
        return this;
    }

    public RepresentantBuilder setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public RepresentantBuilder setEchelon(int echelon) {
        this.echelon = echelon;
        return this;
    }

    public RepresentantBuilder setBase(double base) {
        this.base = base;
        return this;
    }

    public RepresentantBuilder setNbHeures(double nbHeures) {
        this.nbHeures = nbHeures;
        return this;
    }

    public RepresentantBuilder setChiffreAffaires(double chiffreAffaires) {
        this.chiffreAffaires = chiffreAffaires;
        return this;
    }

    public RepresentantBuilder setTauxCommission(double tauxCommission) {
        this.tauxCommission = tauxCommission;
        return this;
    }

    public Representant createRepresentant() {
        return new Representant(nrINSEE, nom, echelon, base, nbHeures, chiffreAffaires, tauxCommission);
    }
}
package fr.umontpellier.iut;

public class Representant extends Commercial{
    private Technicien delegue;

    public Representant(String nrINSEE, String nom, int echelon, double base, double nbHeures, double chiffreAffaires, double tauxCommission) {
        super(nrINSEE, nom, echelon, base, nbHeures, chiffreAffaires, tauxCommission);
        delegue = new Technicien(nrINSEE, nom, echelon, base, nbHeures);
    }

    public void representerEntreprise() {
        System.out.println("Je represente une entreprise. ");
    }

    public double getSalaireBrut() {
        return delegue.getSalaireBrut();
    }
}

package fr.umontpellier.iut;

public class Vendeur extends Commercial {
    public Vendeur(String nrINSEE, String nom, int echelon, double base, double nbHeures, double chiffreAffaires, double tauxCommission) {
        super(nrINSEE, nom, echelon, base, nbHeures, chiffreAffaires, tauxCommission);
    }

    public void vendreProduit() {
        System.out.println("Je vends un produit. ");
    }
}

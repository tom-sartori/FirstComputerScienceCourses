package fr.umontpellier.iut;

import java.util.ArrayList;

public class Compte {
    private String pseudo;
    private String email;
    private String adresse;
    private double solde;
    private ArrayList <OffreEnchere> listeEncheres;

    public Compte(String pseudo, String email, String adresse) {
        this.pseudo = pseudo;
        this.email = email;
        this.adresse = adresse;
        this.solde = 0;
        this.listeEncheres = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Compte{" +
                "pseudo='" + pseudo + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", solde=" + solde +
                '}';
    }

    public void addSolde (double x) {
        this.solde = this.solde + x;
    }

    public OffreEnchere creerOffre(Produit p, double prixC, double prixMax) {
        if (this.solde >= prixMax) {
            System.out.println("Offre prise en compte");
            OffreEnchere offre = new OffreEnchere(p, prixC, prixMax);
            listeEncheres.add(offre);
            return offre;
        }
        else {
            System.out.println("Solde insufisant");
            return null;
        }
    }
}

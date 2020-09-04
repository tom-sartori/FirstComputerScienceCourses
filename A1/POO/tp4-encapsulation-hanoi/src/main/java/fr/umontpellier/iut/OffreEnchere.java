package fr.umontpellier.iut;

import java.time.LocalDate;
import java.time.LocalTime;

public class OffreEnchere {
    private Produit produit;
    private LocalDate date;
    private LocalTime heure;
    private double prixEnCours;
    private double prixMax;
    private boolean estGagnante;

    public OffreEnchere(Produit produit, double prixEnCours, double prixMax) {
        this.produit = produit;
        this.prixEnCours = prixEnCours;
        this.prixMax = prixMax;
        this.date = LocalDate.now();
        this.heure = LocalTime.now();
        this.estGagnante = false;
    }

    @Override
    public String toString() {
        return "OffreEnchere{" +
                "produit=" + produit +
                ", date=" + date +
                ", heure=" + heure +
                ", prixEnCours=" + prixEnCours +
                ", prixMax=" + prixMax +
                '}';
    }

    public double getPrixEnCours() {
        return prixEnCours;
    }

    public double getPrixMax() {
        return prixMax;
    }

    public void setPrixEnCours(double prixEnCours) {
        this.prixEnCours = prixEnCours;
    }

    public void setEstGagnante (boolean b) {
        this.estGagnante = b;
    }

    public Produit getProduit () { return produit; }
}

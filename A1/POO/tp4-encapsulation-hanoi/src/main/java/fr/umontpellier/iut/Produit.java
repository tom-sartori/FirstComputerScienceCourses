package fr.umontpellier.iut;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Produit {
    private int numero;
    private String description;
    private double prixCourant;
    private LocalDate dateDebut;
    private LocalTime heureDebut;
    private static double pas = 3;
    private double coutParticipation;
    private boolean estDisponible;
    private ArrayList <OffreEnchere> listeOffres;
    private OffreEnchere offreGagnante;

    public Produit(int numero, String description, double prixCourant, double coutParticipation) {
        this.numero = numero;
        this.description = description;
        this.prixCourant = prixCourant;
        this.coutParticipation = coutParticipation;
        this.estDisponible = false;
        this.listeOffres = new ArrayList<>();
        this.offreGagnante = null;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "numero=" + numero +
                ", description='" + description + '\'' +
                ", prixCourant=" + prixCourant +
                ", dateDebut=" + dateDebut +
                ", heureDebut=" + heureDebut +
                ", coutParticipation=" + coutParticipation +
                ", estDisponible=" + estDisponible +
                '}';
    }

    public static void setPas(double n) {
        Produit.pas = n;
    }

    public void demarrerEnchere () {
        if (!this.estDisponible) {
            this.estDisponible = true;
            this.dateDebut = LocalDate.now();
            this.heureDebut = LocalTime.now();
        }
    }

    public void arreterEnchere () {
        this.estDisponible = false;
    }


    public void ajouterOffre (OffreEnchere nouvelleOffre) {
        if (!estDisponible) {
            System.out.println("Produit indisponible pour le moment ");
            return;
        }
        if (nouvelleOffre == null) {
            System.out.println("Offre nulle");
            return;
        }
        if (nouvelleOffre.getProduit() != this) {
            System.out.println("Offre sur le mauvais produit");
            return;
        }
        if (nouvelleOffre.getPrixEnCours() > nouvelleOffre.getPrixMax()) {
            System.out.println("Offre non valide ; max < courant");
            return;
        }

        if (offreGagnante == null) {    // Cas de la premiere offre
            if (nouvelleOffre.getPrixEnCours() >= prixCourant) {
                initNewGagnant(nouvelleOffre);
                prixCourant = offreGagnante.getPrixEnCours();
            } else { // if (nouvelleOffre.getPrixEnCours() < prixCourant)
                System.out.println("Prix courant de l'offre insufisant");
                return;
            }
        }
        else { // if (offreGagnante != null)
            if (nouvelleOffre.getPrixEnCours() > offreGagnante.getPrixMax()) {
                initNewGagnant(nouvelleOffre);
                prixCourant = offreGagnante.getPrixEnCours();
            }
            else { // if (nouvelleOffre.getPrixEnCours() <= offreGagnante.getPrixMax())
                if (nouvelleOffre.getPrixEnCours() >= prixCourant + pas) {
                    if (nouvelleOffre.getPrixMax() == offreGagnante.getPrixMax())
                        prixCourant = offreGagnante.getPrixMax();
                    else if (nouvelleOffre.getPrixMax() < offreGagnante.getPrixMax()) {
                        if (nouvelleOffre.getPrixMax() + pas < offreGagnante.getPrixMax())
                            prixCourant = nouvelleOffre.getPrixMax() + pas;
                        else // if (nouvelleOffre.getPrixMax() + pas >= offreGagnante.getPrixMax())
                            prixCourant = offreGagnante.getPrixMax();
                    }
                    else { // if (nouvelleOffre.getPrixMax() > offreGagnante.getPrixMax())
                        if (offreGagnante.getPrixMax() + pas < nouvelleOffre.getPrixMax()) {
                            prixCourant = offreGagnante.getPrixMax() + pas;
                            initNewGagnant(nouvelleOffre);
                        }
                        else { // if (offreGagnante.getPrixMax() + pas >= nouvelleOffre.getPrixMax())
                            prixCourant = nouvelleOffre.getPrixMax();
                            initNewGagnant(nouvelleOffre);
                        }
                    }
                }
                else { // if (nouvelleOffre.getPrixEnCours() < prixCourant + pas)
                    System.out.println("Prix courant de l'offre insufisant");
                    return;
                }
            }
        }
        System.out.println("Nouveau prix courant : " + prixCourant);
    }

    public double getPrixCourant () {
        return this.prixCourant;
    }

    private void initNewGagnant (OffreEnchere newOffre) {
        newOffre.setEstGagnante(true);
        offreGagnante = newOffre;
        listeOffres.add(offreGagnante);
    }

    public OffreEnchere getGagnant() {
        return offreGagnante;
    }

    public boolean getEstDisponible() {
        return estDisponible;
    }
}

package fr.umontpellier.iut.exo3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EtudiantTelescopique {
    private String nom;
    private String prenom;
    private LocalDate dateNai;
    private String adresseM;
    private String adresseP;
    private List<Note> listeNotes;

    public EtudiantTelescopique(String nom, String prenom, LocalDate dateNai, String adresseM, String adresseP) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNai = dateNai;
        this.adresseM = adresseM;
        this.adresseP = adresseP;
        this.listeNotes = new ArrayList<>();
    }

    public EtudiantTelescopique(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.listeNotes = new ArrayList<>();
    }

    public EtudiantTelescopique(String nom, String prenom, LocalDate dateNai) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNai = dateNai;
        this.listeNotes = new ArrayList<>();
    }

    public EtudiantTelescopique(String nom, String prenom, String adresseM) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresseM = adresseM;
        this.listeNotes = new ArrayList<>();
    }

    public String toString () {
        return this.nom + " " + this.prenom + ", né le " + this.dateNai + ", habite " + this.adresseP + ". Mail : " + this.adresseM;
    }

    public void setNom (String nom) {
        this.nom = nom;
    }

    public void noter (Matiere m, double n) {
        this.listeNotes.add(new Note(m, n));
    }

    public double calculerMoyenne () {
        double x = 0, coef, moyenne = 0, diviseur = 0;

        for(Note note:listeNotes) {
            x = note.getValeur();
            coef = note.getMatiere().getCoefficient();
            moyenne = moyenne + (x * coef);
            diviseur = diviseur + coef;
        }
        if (moyenne == 0)
            return 0;
        else
            return moyenne / diviseur;
    }
}

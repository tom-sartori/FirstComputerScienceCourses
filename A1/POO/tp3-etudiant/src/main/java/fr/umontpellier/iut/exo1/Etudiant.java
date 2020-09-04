package fr.umontpellier.iut.exo1;

import java.time.LocalDate;

public class Etudiant {
    private String nom;
    private String prenom;
    private LocalDate dateNai;
    private String adresseM;
    private String adresseP;

    public Etudiant(String nom, String prenom, LocalDate dateNai, String adresseM, String adresseP) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNai = dateNai;
        this.adresseM = adresseM;
        this.adresseP = adresseP;
    }

    public String toString () {
        return this.nom + " " + this.prenom + " est né le " + this.dateNai + ", habite " + this.adresseP + ". Mail : " + this.adresseM;
    }

    public void setNom (String nom) {
        this.nom = nom;
    }
}

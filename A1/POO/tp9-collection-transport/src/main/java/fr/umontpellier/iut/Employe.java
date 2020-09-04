package fr.umontpellier.iut;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Employe implements Comparable<Employe> {
    private String nrINSEE;
    private String nom;
    private double base;

    private LocalDate dateEmbauche;

    private double bonus; // pour exo3

    private String adresse; // pour exo4

    public Employe(String nrINSEE, String nom, double base) {
        this.nrINSEE = nrINSEE;
        this.nom = nom;
        this.base = base;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nrINSEE='" + nrINSEE + '\'' +
                ", nom='" + nom + '\'' +
                ", base=" + base +
                ", dateEmbauche=" + dateEmbauche +
                ", bonus=" + bonus +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(nrINSEE, employe.nrINSEE) &&
                Objects.equals(nom, employe.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nrINSEE, nom);
    }

    @Override
    public int compareTo(Employe o) {
        if (this.equals(o))
            return 0;
        if (this.nom.equals(o.nom))
            return o.nrINSEE.compareTo(this.nrINSEE);
        else
            return this.nom.compareTo(o.nom);
    }


    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public int getMoisAnciennete() {
        return (int)ChronoUnit.MONTHS.between(dateEmbauche, LocalDate.now());
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getIndemniteTransport() {
        return GestionDistances.getDistance(this.adresse) * base;
    }
}

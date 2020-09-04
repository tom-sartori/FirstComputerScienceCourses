package fr.umontpellier.iut.exo3;

import java.util.ArrayList;
import java.util.List;

public class Departement {
    private String spe;
    private String adresse;
    private List<Etudiant> listeEtu;

    public Departement(String spe, String adresse) {
        this.spe = spe;
        this.adresse = adresse;
        this.listeEtu = new ArrayList<>();
    }

    public String toString() {
        return "Departement{" +
                "liste des etudiants : " + this.listeEtu +
                '}';
    }

    public void inscrire (Etudiant e) {
        this.listeEtu.add(e);
    }

    public void desinscrire (Etudiant e) {
        this.listeEtu.remove(e);
    }
}

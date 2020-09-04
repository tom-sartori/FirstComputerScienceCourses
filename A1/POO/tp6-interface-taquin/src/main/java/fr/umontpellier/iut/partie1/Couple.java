package fr.umontpellier.iut.partie1;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("Duplicates")

public class Couple {

    private Taquin taquin;
    private Couple predecesseur;

    public Couple(Taquin taquin, Couple predecesseur) {
        this.taquin = taquin;
        this.predecesseur = predecesseur;
    }


    public Taquin getTaquin() {
        return taquin;
    }


    public void mettreAJour(ArrayList<Couple> frontiere, ArrayList<Taquin> dejaVus) {
        ArrayList<Taquin> listeFils = taquin.genererFils();

        for (Taquin taquin : listeFils) {
            if (!dejaVus.contains(taquin)) {
                dejaVus.add(taquin);
                Couple c = new Couple(taquin, this);
                frontiere.add(c);
            }
        }
    }


    public ArrayList<Taquin> getListeDeMouvements() {
        ArrayList<Taquin> list = new ArrayList<>();

        if (taquin == null)
            return list;

        Couple c = this;

        while (c != null) {
            list.add(c.taquin);
            c = c.predecesseur;
        }
        Collections.reverse(list);
        return list;
    }
}

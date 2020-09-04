package fr.umontpellier.iut.partie2;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("Duplicates")

public class Couple {

    private JeuPuzzle taquin;
    private Couple predecesseur;

    public Couple(JeuPuzzle taquin, Couple predecesseur) {
        this.taquin = taquin;
        this.predecesseur = predecesseur;
    }


    public JeuPuzzle getTaquin() {
        return taquin;
    }


    public void mettreAJour(ArrayList<Couple> frontiere, ArrayList<JeuPuzzle> dejaVus) {
        ArrayList<JeuPuzzle> listeFils = taquin.genererFils();

        for (JeuPuzzle taquin : listeFils) {
            if (!dejaVus.contains(taquin)) {
                dejaVus.add(taquin);
                Couple c = new Couple(taquin, this);
                frontiere.add(c);
            }
        }
    }


    public ArrayList<JeuPuzzle> getListeDeMouvements() {
        ArrayList<JeuPuzzle> list = new ArrayList<>();

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

package fr.umontpellier.iut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@SuppressWarnings("Duplicates")

public class Contexte {

    private JeuPuzzle taquinInitial;
    private ArrayList<JeuPuzzle> solution;

    public Contexte(JeuPuzzle taquinInitial) {
        this.taquinInitial = taquinInitial;
        solution = new ArrayList<JeuPuzzle>();
    }

    @Override
    public String toString() {
        StringBuilder ch = new StringBuilder();

        if (!solution.isEmpty())
            ch.append("La solution est : \n");

        for (JeuPuzzle element : solution) {
            ch.append(element.toString()+"\n");
        }
        return String.valueOf(ch);
    }


    public void resoudre() {
        Collection<JeuPuzzle> dejaVus = new HashSet<>();
        dejaVus.add(taquinInitial);

        ArrayList<Couple> frontiere = new ArrayList<>();
        Couple c1 = new Couple(taquinInitial, null);
        frontiere.add(c1);

        int taille = frontiere.size();

        while (true) {
            for (int i = 0; i < taille; i++) {
                frontiere.get(0).mettreAJour(frontiere, dejaVus);
                if (frontiere.get(0).getTaquin().estGagnant()) {
                    System.out.println("Ce puzzle possede une solution. \n");
                    solution = frontiere.get(0).getListeDeMouvements();
                    return;
                }
                else
                    frontiere.remove(0);

                if (frontiere.size() == 0) {
                    System.out.println("Ce puzzle ne possede pas de solution. ");
                    return;
                }
            }
            taille = frontiere.size();
        }
    }


    public ArrayList<JeuPuzzle> getSolution() {
        return solution;
    }
}

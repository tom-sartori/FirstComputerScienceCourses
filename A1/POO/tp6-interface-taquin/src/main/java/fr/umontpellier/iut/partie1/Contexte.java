package fr.umontpellier.iut.partie1;

import java.util.ArrayList;

@SuppressWarnings("Duplicates")

public class Contexte {

    private Taquin taquinInitial;
    private ArrayList<Taquin> solution;

    public Contexte(Taquin taquinInitial) {
        this.taquinInitial = taquinInitial;
        solution = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder ch = new StringBuilder();

        for (Taquin element : solution) {
            ch.append(element.toString()+"\n");
        }
        return String.valueOf(ch);
    }


    public void resoudre() {
        ArrayList<Taquin> dejaVu = new ArrayList<>();
        dejaVu.add(taquinInitial);

        ArrayList<Couple> frontiere = new ArrayList<>();
        Couple c1 = new Couple(taquinInitial, null);
        frontiere.add(c1);

        boolean rester = true;
        int taille = frontiere.size();

        while (rester) {
            for (int i = 0; i < taille; i++) {
                frontiere.get(0).mettreAJour(frontiere, dejaVu);
                if (frontiere.get(0).getTaquin().estGagnant()) {
                    System.out.println("Taquin gagnant. \n");
                    solution = frontiere.get(0).getListeDeMouvements();
                    rester = false;
                    return;
                }
                else
                    frontiere.remove(0);

                if (frontiere.size() == 0) {
                    System.out.println("Pas de solution. ");
                    rester = false;
                    return;
                }
            }
            taille = frontiere.size();
        }
    }


    public ArrayList<Taquin> getSolution() {
        return solution;
    }
}

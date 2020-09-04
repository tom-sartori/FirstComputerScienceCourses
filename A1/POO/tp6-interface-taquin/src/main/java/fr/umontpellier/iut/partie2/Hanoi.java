package fr.umontpellier.iut.partie2;

import java.util.ArrayList;
import java.util.Objects;

public class Hanoi implements JeuPuzzle {

    private ArrayList<Integer> tour1;
    private ArrayList<Integer> tour2;
    private ArrayList<Integer> tour3;
    private int taille;

    public Hanoi(int taille) {
        tour1 = new ArrayList<>();
        tour2 = new ArrayList<>();
        tour3 = new ArrayList<>();
        this.taille = taille;

        for (int i = 1; i <= taille; i++)
            tour1.add(0, i);
    }


    public Hanoi(ArrayList<Integer> tour1, ArrayList<Integer> tour2, ArrayList<Integer> tour3, int taille) {
        this.tour1 = new ArrayList<>(tour1);
        this.tour2 = new ArrayList<>(tour2);
        this.tour3 = new ArrayList<>(tour3);
        this.taille = taille;
    }

    @Override
    public String toString() {
        return "Hanoi{" +
                "tour1=" + tour1 +
                ", tour2=" + tour2 +
                ", tour3=" + tour3 +
                ", taille=" + taille +
                '}';
    }


    @Override
    public boolean estGagnant() {
        if (tour3.size() != taille)
            return false;
        if (taille == 0)
            return true;
        Integer x = tour3.get(0);
        for (Integer element: tour3) {
            if (x < element)
                return false;
            x = element;
        }
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hanoi hanoi = (Hanoi) o;
        return taille == hanoi.taille &&
                Objects.equals(tour1, hanoi.tour1) &&
                Objects.equals(tour2, hanoi.tour2) &&
                Objects.equals(tour3, hanoi.tour3);
    }


    @Override
    public int hashCode() {
        return Objects.hash(tour1, tour2, tour3, taille);
    }


    private boolean estPossible (ArrayList<Integer> t1, ArrayList<Integer> t2) {
        if (t1.isEmpty())
            return false;
        if (t2.isEmpty())
            return true;
        if (t1.get(t1.size()-1) < t2.get(t2.size() -1))
            return true;
        return false;
    }


    @Override
    public ArrayList<JeuPuzzle> genererFils() {
        ArrayList<JeuPuzzle> listeFils = new ArrayList<>();
        if (tour1.size() != 0) {
            if (estPossible(tour1, tour2)) {
                ArrayList<Integer> data1 = new ArrayList<>(this.tour1);
                ArrayList<Integer> data2 = new ArrayList<>(this.tour2);
                data2.add(data1.get(data1.size() -1));
                data1.remove(data1.size() -1);
                Hanoi h = new Hanoi(data1, data2, this.tour3, this.taille);
                listeFils.add(h);
            }
            if (estPossible(tour1, tour3)) {
                ArrayList<Integer> data1 = new ArrayList<>(this.tour1);
                ArrayList<Integer> data2 = new ArrayList<>(this.tour3);
                data2.add(data1.get(data1.size() -1));
                data1.remove(data1.size() -1);
                Hanoi h = new Hanoi(data1, this.tour2, data2, this.taille);
                listeFils.add(h);
            }
        }
        if (tour2.size() != 0) {
            if (estPossible(tour2, tour1)) {
                ArrayList<Integer> data1 = new ArrayList<>(this.tour2);
                ArrayList<Integer> data2 = new ArrayList<>(this.tour1);
                data2.add(data1.get(data1.size() -1));
                data1.remove(data1.size() -1);
                Hanoi h = new Hanoi(data2, data1, this.tour3, this.taille);
                listeFils.add(h);
            }
            if (estPossible(tour2, tour3)) {
                ArrayList<Integer> data1 = new ArrayList<>(this.tour2);
                ArrayList<Integer> data2 = new ArrayList<>(this.tour3);
                data2.add(data1.get(data1.size() -1));
                data1.remove(data1.size() -1);
                Hanoi h = new Hanoi(this.tour1, data1, data2, this.taille);
                listeFils.add(h);
            }
        }
        if (tour3.size() != 0) {
            if (estPossible(tour1, tour2)) {
                ArrayList<Integer> data1 = new ArrayList<>(this.tour3);
                ArrayList<Integer> data2 = new ArrayList<>(this.tour1);
                data2.add(data1.get(data1.size() -1));
                data1.remove(data1.size() -1);
                Hanoi h = new Hanoi(data2, this.tour2, data1, this.taille);
                listeFils.add(h);
            }
            if (estPossible(tour1, tour3)) {
                ArrayList<Integer> data1 = new ArrayList<>(this.tour3);
                ArrayList<Integer> data2 = new ArrayList<>(this.tour2);
                data2.add(data1.get(data1.size() -1));
                data1.remove(data1.size() -1);
                Hanoi h = new Hanoi(this.tour1, data2, data1, this.taille);
                listeFils.add(h);
            }
        }
        return listeFils;
    }
}


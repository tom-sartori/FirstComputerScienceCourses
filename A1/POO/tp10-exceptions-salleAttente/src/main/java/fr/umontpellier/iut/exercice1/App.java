package fr.umontpellier.iut.exercice1;

public class App {

    public static void main(String[] arg) {

        Personne p1 = new Personne("Jean");
        Personne p2 = new Personne("Denis");

        SalleAttente salleAttente = new SalleAttente();

        salleAttente.entrer(p1, 4);
        salleAttente.entrer(p2, 3);

        salleAttente.sortir();
        salleAttente.sortir();

    }
}

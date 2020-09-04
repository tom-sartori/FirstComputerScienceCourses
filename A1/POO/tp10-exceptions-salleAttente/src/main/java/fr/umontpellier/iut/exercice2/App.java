package fr.umontpellier.iut.exercice2;

import fr.umontpellier.iut.exercice1.Personne;
import fr.umontpellier.iut.exercice1.PersonnePriorisee;
import fr.umontpellier.iut.exercice1.TypePriorise;
import fr.umontpellier.iut.exercice2.exceptions.SalleCapaciteLimiteeException;
import fr.umontpellier.iut.exercice2.exceptions.SalleVideException;
import org.junit.jupiter.api.Test;

public class App {
    public static void main(String[] args) throws SalleVideException {

        SalleCapaciteLimitee salleAttenteLimitee = new SalleCapaciteLimitee(3);

        //salleAttenteLimitee.personneSuivante();

        Personne personne = new Personne("Xavier");
        Personne personne1 = new Personne("Thomas");
        Personne personne2 = new Personne("Hugo");
        Personne personne3 = new Personne("Louis");

        try {
            salleAttenteLimitee.entrer(personne, 5);
        } catch (SalleCapaciteLimiteeException e) {
            System.out.println(e.getMessage());
        }

        try {
            salleAttenteLimitee.entrer(personne1, 2);
        } catch (SalleCapaciteLimiteeException e) {
            System.out.println(e.getMessage());
        }

        try {
            salleAttenteLimitee.entrer(personne2, 8);
        } catch (SalleCapaciteLimiteeException e) {
            System.out.println(e.getMessage());
        }

        try {
            salleAttenteLimitee.entrer(personne3, 1);
        } catch (SalleCapaciteLimiteeException e) {
            System.out.println(e.getMessage());
        }

        /*
        System.out.println(salleAttenteLimitee.personneSuivante());
        System.out.println(salleAttenteLimitee.personneSuivante());
        System.out.println(salleAttenteLimitee.personneSuivante());
        System.out.println(salleAttenteLimitee.personneSuivante());
*/

        salleAttenteLimitee.personneSuivante();
        salleAttenteLimitee.personneSuivante();
        salleAttenteLimitee.personneSuivante();
        try {
            salleAttenteLimitee.personneSuivante();
        } catch (SalleVideException e) {
            System.out.println(e.getMessage());
        }
    }
}

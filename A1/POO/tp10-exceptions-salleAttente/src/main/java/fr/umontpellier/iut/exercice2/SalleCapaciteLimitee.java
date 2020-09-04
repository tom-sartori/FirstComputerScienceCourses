package fr.umontpellier.iut.exercice2;

import fr.umontpellier.iut.exercice1.Personne;
import fr.umontpellier.iut.exercice1.SalleAttente;
import fr.umontpellier.iut.exercice2.exceptions.CapaciteMaximaleAtteinteException;
import fr.umontpellier.iut.exercice2.exceptions.SalleVideException;

public class SalleCapaciteLimitee {

    private SalleAttente salle;
    private int max;
    private int nbPersonnes;

    public SalleCapaciteLimitee(int n) {
        salle = new SalleAttente();
        max = n;
        nbPersonnes = 0;
    }

    public void entrer(Personne p, int priorite) throws CapaciteMaximaleAtteinteException {
        if (nbPersonnes < max) {
            salle.entrer(p, priorite);
            nbPersonnes++;
        }
        else {
            throw new CapaciteMaximaleAtteinteException(max);
        }
    }

    public String personneSuivante() throws SalleVideException {
        try {
            return salle.sortir().toString();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new SalleVideException();
        }
    }
}

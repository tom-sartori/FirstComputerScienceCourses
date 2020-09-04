package fr.umontpellier.iut.exercice2.exceptions;

public class CapaciteMaximaleAtteinteException extends SalleCapaciteLimiteeException {

    public CapaciteMaximaleAtteinteException(int n) {
        super("Cette salle est pleine, elle est limitée à " + n + " personnes.");
    }
}

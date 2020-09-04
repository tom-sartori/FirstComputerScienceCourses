package fr.umontpellier.iut.expressions;

public class Operation implements Expression {

    private char operateur;
    private Expression expressionGauche;
    private Expression expressionDroite;

    public Operation(char operateur, Expression expressionGauche, Expression expressionDroite) {
        this.operateur = operateur;
        this.expressionGauche = expressionGauche;
        this.expressionDroite = expressionDroite;
    }

    @Override
    public double calculerValeur() {
        if (operateur == '+')
            return expressionGauche.calculerValeur() + expressionDroite.calculerValeur();
        if (operateur == '*')
            return expressionGauche.calculerValeur() * expressionDroite.calculerValeur();
        if (operateur == '-')
            return expressionGauche.calculerValeur() - expressionDroite.calculerValeur();
        if (operateur == '/') {
            if (expressionDroite.calculerValeur() == 0)
                throw new ArithmeticException("Division par zéro");
            return expressionGauche.calculerValeur() / expressionDroite.calculerValeur();
        }
        System.out.println("Erreur dans calculerValeur");
        return 0;
    }

    @Override
    public String toString() {
        return "(" + expressionGauche + " " + operateur + " " + expressionDroite + ")";
    }
}

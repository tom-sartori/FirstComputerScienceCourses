package fr.umontpellier.iut.expressions;

public class AppExpression {

    public static void main(String[] args) {
        Expression e = new Operation('*', new Nombre(10), new Nombre(5));
        System.out.println(e);
    }
}

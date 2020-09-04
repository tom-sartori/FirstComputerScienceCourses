package fr.umontpellier.iut;

import java.time.LocalDate;

public class GestionEmployes {

    public static void main(String[] args) {

        Employe employe = new Employe("111", "Dupont", 1000);
        Employe employe1 = new Employe("222", "Morrison", 1600);
        Employe employe2 = new Employe("333", "Petit", 2000);

        Entreprise entreprise = new Entreprise();
        System.out.println("1 : " + entreprise);

        entreprise.embaucher(employe, LocalDate.of(2013, 4, 14));
        System.out.println("2 : " + entreprise);

        entreprise.embaucher(employe1, LocalDate.of(2015, 1, 12));
        System.out.println("3 : " + entreprise);

        entreprise.embaucher(employe2, LocalDate.of(2018, 5, 5));
        System.out.println("4 : " + entreprise);

        System.out.println("Liste ordo : " + entreprise.getEmployesOrdonnes());
        System.out.println("liste desord : " + entreprise.getEmployesDansDesordre());

        entreprise.licencier(employe1);
        System.out.println("5 : " + entreprise);

        Employe employe3 = new Employe("111", "Dupont", 500);

        System.out.println(employe.hashCode() == employe3.hashCode());
        System.out.println(employe.equals(employe3));

    }
}

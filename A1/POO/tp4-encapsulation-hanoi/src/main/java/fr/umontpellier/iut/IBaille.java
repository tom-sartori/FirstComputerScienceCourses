package fr.umontpellier.iut;

import java.util.Scanner;

public class IBaille {
    public static void main(String[] args) {

        Scanner saisie;

        Compte c = null;
        Compte c1 = new Compte("Jean", "jean@gmail.com", "3 rue");
        Compte c2 = new Compte("Pat", "pat@gmail.com", "4 rue");
        Compte c3 = new Compte("Jordan", "jordan@gmail.com", "5 rue");

        c1.addSolde(1000);
        c2.addSolde(1000);
        c3.addSolde(1000);

        Produit p = null;
        Produit p1 = new Produit(001, "Tele", 50, 1);
        Produit p2 = new Produit(002, "Table", 20, 1);

        System.out.println("Bonjour et bienvenue sur IBaille ");

        System.out.println("");
        System.out.println("Voici les produits disponibles : \n" + p1 + "\n" + p2);

        boolean passProduit = false;
        while (!passProduit) {
            System.out.println("");
            saisie = new Scanner(System.in);
            System.out.print("Tapez le numero du produit pour lequel vous souhaitez enchérir ou 0 pour quitter : ");
            int numProduit = saisie.nextInt();

            if (numProduit == 0) {
                System.out.println("Merci de votre visite. ");
                return;
            }
            else if (numProduit == 1) {
                p = p1;
                passProduit = true;
            }
            else if (numProduit == 2) {
                p = p2;
                passProduit = true;
            }
            else
                System.out.println("Mauvais produit selectionné");
        }

        System.out.println("");
        p.demarrerEnchere();
        System.out.println("Produit selectionné : " + p);
        System.out.println("");


        while (p.getEstDisponible()) {

            boolean passPseudo = false;
            while (!passPseudo) {
                saisie = new Scanner(System.in);
                System.out.print("Indiquez votre numero identifiant : "); //Fait avec un numero id car ne fonctionnait pas avec scanner de String du pseudo
                int id = saisie.nextInt();

                if (id == 1) {
                    c = c1;
                    passPseudo = true;
                } else if (id == 2) {
                    c = c2;
                    passPseudo = true;
                } else if (id == 3) {
                    c = c3;
                    passPseudo = true;
                } else
                    System.out.println("Identifiant incorrect");
            }

            System.out.println("Compte associé : " + c);

            System.out.println("");

            boolean passChoix = false;
            while (!passChoix) {
                saisie = new Scanner(System.in);
                System.out.print("Si vous souhaitez enchérir tapez 1 sinon 0. ");
                int choix = saisie.nextInt();

                if (choix == 0) {
                    if (p.getGagnant() == null) {
                        System.out.println("Merci et à bientot. ");
                        return;
                    }
                    else {
                        System.out.println("");
                        p.arreterEnchere();
                        System.out.println("Le produit : " + p + " a été vendu pour " + p.getGagnant().getPrixEnCours() + " euros. ");
                        return;
                    }
                }
                else if (choix != 1)
                    System.out.println("Choix incomprit");
                else
                    passChoix = true;
            }



            System.out.println("");

            System.out.println("Produit selectionné : " + p);
            saisie = new Scanner(System.in);
            System.out.print("Indiquez le prix courant souhaité : ");
            double courant = saisie.nextDouble();

            saisie = new Scanner(System.in);
            System.out.print("Indiquez le prix max souhaité : ");
            double max = saisie.nextDouble();

            System.out.println("");

            p1.ajouterOffre(c.creerOffre(p1, courant, max));

        }

    }



}

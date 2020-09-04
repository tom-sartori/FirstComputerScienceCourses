package fr.umontpellier.iut;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ProduitTest {

    private Produit p1, p2, p3;
    private Compte c1, c2, c3;
    private OffreEnchere o1, o2, o3, o4, o5, o6;

    @BeforeEach
    void initialisation () {
        p1 = new Produit(001, "Table", 20, 1);
        p2 = new Produit(002, "Brouette", 10, 1);
        p3 = new Produit(003, "Arc", 25, 1);

        c1 = new Compte("Jean", "jean@gmail.com", "3 rue");
        c2 = new Compte("Pat", "pat@gmail.com", "4 rue");
        c3 = new Compte("Jordan", "jordan@gmail.com", "5 rue");

        o2 = new OffreEnchere(p1, 25, 50);
        o3 = new OffreEnchere(p1, 19, 40);
        o4 = new OffreEnchere(p3, 30, 35);
        o5 = new OffreEnchere(p1, 30, 50);
        o6 = new OffreEnchere(p1, 20, 50);

        p1.setPas(3);
        p1.demarrerEnchere();
        p3.demarrerEnchere();
    }

    @Test
    void test_prixC_ajout_offre_null_sur_produit_indisponible () {
        p2.ajouterOffre(o1);
        assertEquals(10, p2.getPrixCourant());
    }

    @Test
    void test_prixC_ajout_offre_valide_sur_produit_indispo () {
        p2.ajouterOffre(o2);
        assertEquals(10, p2.getPrixCourant());
    }

    @Test
    void test_prixC_avec_premiere_offre_null () {
        p1.ajouterOffre(o1);
        assertEquals(20, p1.getPrixCourant());
    }

    @Test
    void test_ajout_offre_valide () {
        p1.ajouterOffre(o2);
        assertEquals(25, p1.getPrixCourant());
    }

    @Test
    void test_prixC_avec_deuxieme_offre_null () {
        p1.ajouterOffre(o2);
        p1.ajouterOffre(o1);
        assertEquals(25, p1.getPrixCourant());
    }

    @Test
    void test_prixC_ajout_offre_non_valide () {
        p1.ajouterOffre(o3);
        assertEquals(20, p1.getPrixCourant());
    }

    @Test
    void test_prixC_ajout_offre_mauvais_produit_sur_produit () {
        p1.ajouterOffre(o4);
        assertEquals(20, p1.getPrixCourant());
    }

    @Test
    void test_prixC_ajout_offre_sur_mauvais_produit () {
        p3.ajouterOffre(o1);
        assertEquals(25, p3.getPrixCourant());
    }

    @Test
    void test_prixC_deuxieme_offre_valide_avec_meme_max () {
        p1.ajouterOffre(o2);
        p1.ajouterOffre(o5);
        assertEquals(50, p1.getPrixCourant());
    }
    @Test
    void test_prixC_ajout_deuxieme_offre_non_valide_avec_meme_max () {
        OffreEnchere o = new OffreEnchere(p1, 15, 50);
        p1.ajouterOffre(o2);
        p1.ajouterOffre(o);
        assertEquals(25, p1.getPrixCourant());
    }

    @Test
    void test_prixC_ajout_premiere_offre_egale_au_prixC () {
        p1.ajouterOffre(o6);
        assertEquals(20, p1.getPrixCourant());
    }

    @Test
    void test_prixC_ajout_offre_respectant_pas_le_pas () {
        p1.ajouterOffre(o2);
        OffreEnchere o = new OffreEnchere(p1, 26, 50);
        p1.ajouterOffre(o);
        assertEquals(25, p1.getPrixCourant());
    }

    @Test
    void test_priC_nouvelle_offre_avec_priC_sup_a_ancien_max () {
        p1.ajouterOffre(o2);
        OffreEnchere o = new OffreEnchere(p1, 51, 100);
        p1.ajouterOffre(o);
        assertEquals(51, p1.getPrixCourant());
    }


}
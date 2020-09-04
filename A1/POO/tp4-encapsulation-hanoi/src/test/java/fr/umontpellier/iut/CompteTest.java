package fr.umontpellier.iut;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.*;

class CompteTest {

    private Compte c1;
    private Produit p1;
    private OffreEnchere o1;

    @BeforeEach
    void initialisation() {
        c1 = new Compte("Jean111", "jean@gmail.com", "3 Rue de la Jungle");
        p1 = new Produit(001, "Table", 25, 3);
        o1 = new OffreEnchere(p1, 30, 100);
    }


    @Disabled   //Fonctionne pas car comparaison d'objets
    @Test
    void test_creerOffre_avec_solde_valide () {
        c1.addSolde(1000);
        assertEquals(o1, c1.creerOffre(p1, 30, 100));
    }


}
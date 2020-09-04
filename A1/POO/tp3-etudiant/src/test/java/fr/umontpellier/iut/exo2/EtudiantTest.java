package fr.umontpellier.iut.exo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EtudiantTest {

    private Etudiant e1;
    private Professeur p1;
    private Matiere m1;


    @BeforeEach
    void initialisatio(){
        e1 = new Etudiant("Dos", "Math", LocalDate.of(2000, 05, 20), "d.math@gmail.com", "20 rue de la foret");
        p1 = new Professeur("MJ", "Alain");
        m1 = new Matiere("Maths", 2, p1);
    }


    @Test
    void test_calculer_moyenne_retourne_0_Quand_Pas_De_Note() { assertEquals(e1.calculerMoyenne(), 0); }

    @Test
    void test_calculer_moyenne_retourne_valeur_note_quand_une_seule_note() {
        e1.noter(m1, 17);
        assertEquals(e1.calculerMoyenne(), 17);
    }

    @Test
    void test_calculer_moyenne_retourne_valeur_note_pondérée_quand_une_seule_note_avec_coefficient() {
        e1.noter(m1, 15.2);
        assertEquals(e1.calculerMoyenne(), 15.2);
    }

    @Test
    void test_calculer_moyenne_retourne_moyenne_quand_plusieurs_notes_avec_differents_coefficients() {
        e1.noter(m1, 20);
        Matiere m2 = new Matiere("Prog", 4, p1);
        //Matiere m3 = new Matiere("Archi", 3, p1);
        e1.noter(m2, 5);
        //e1.noter(m3, 10);
        assertEquals(e1.calculerMoyenne(), 10);
    }
}
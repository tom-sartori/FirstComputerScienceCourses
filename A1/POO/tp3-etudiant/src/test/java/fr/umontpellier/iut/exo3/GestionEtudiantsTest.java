package fr.umontpellier.iut.exo3;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class GestionEtudiantsTest {

    @Disabled
    @Test
    public void test_if_main_method_does_not_throw_exceptions() {

        assertDoesNotThrow(() -> GestionEtudiants.main(new String[1]));

    }

}
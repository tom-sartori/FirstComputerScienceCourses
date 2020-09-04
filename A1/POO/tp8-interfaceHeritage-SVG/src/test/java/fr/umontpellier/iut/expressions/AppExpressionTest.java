package fr.umontpellier.iut.expressions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AppExpressionTest {

    @Test
    public void test_if_main_method_was_implemented() {
        assertDoesNotThrow(() -> AppExpression.main(new String[1]));
    }

}
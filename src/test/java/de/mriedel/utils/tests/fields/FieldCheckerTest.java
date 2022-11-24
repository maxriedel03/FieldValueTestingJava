package de.mriedel.utils.tests.fields;

import de.mriedel.utils.tests.fields.implementations.FieldCheckerImpl;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FieldCheckerTest {

    @Data
    @EqualsAndHashCode
    @Builder
    private static class MockClass{
        private String field1;
        private String field2;
    }

    @Test
    @DisplayName("Check if field holds value")
    void checkIfFieldHoldsValueTest() {
        FieldChecker fieldChecker = new FieldCheckerImpl();
        MockClass mockClass = MockClass.builder()
                .field1("field1")
                .field2("field2")
                .build();
        Assertions.assertTrue(fieldChecker.checkIfFieldHoldsValue(mockClass,
                "field1", "field1"),
                "Field should hold value: " + mockClass.getField1());
        Assertions.assertFalse(fieldChecker.checkIfFieldHoldsValue(mockClass,
                "field1", "field2"),
                "Field should not hold value: field2");
        Assertions.assertTrue(fieldChecker.checkIfFieldHoldsValue(mockClass,
                "field2", "field2"),
                "Field should hold value: " + mockClass.getField2());
        Assertions.assertFalse(fieldChecker.checkIfFieldHoldsValue(mockClass,
                "field2", "field1"),
                "Field should not hold value: field1");
        Assertions.assertFalse(fieldChecker.checkIfFieldHoldsValue(mockClass,
                "field3", new Object()),
                "Field should equal to a Object of different class");
    }
}
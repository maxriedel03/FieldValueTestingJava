package de.mriedel.utils.tests.fields;

/**
 * Interface for checking Fields of Objects.
 * @author mriedel
 * @version 1.0
 * @since 1.0
 * @see de.mriedel.utils.tests.fields.implementations.FieldCheckerImpl
 */
public interface FieldChecker{

    /**
     * Checks if the given Field name of the given Object holds the given value.
     * When the Field is not found or the an {@link IllegalAccessException} occurs, false is returned.
     * @param obj the Object to check
     * @param fieldName the name of the field to check
     * @param value the value to check
     * @return true if the field holds the value, false otherwise
     */
    boolean checkIfFieldHoldsValue(Object obj, String fieldName, Object value);
}

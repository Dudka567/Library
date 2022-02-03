package src.main.java.controller.validators;

public interface Validator {
    ValidationResult validatePair(String key, String value);
}

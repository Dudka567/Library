package controller.validators;

public interface Validator {
    ValidationResult validatePair(String key, String value);
}

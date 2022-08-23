package com.validators;

public interface Validator {
    ValidationResult validatePair(String key, String value);
}

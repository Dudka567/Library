package src.main.java.controller.validators;

public class ValidationResult {
    private static final String INCORRECT_KEY_AND_VALUE_FORMAT = "Incorrect key and value format.";
    private static final String INCORRECT_KEY_FORMAT = "Incorrect key format.";
    private static final String INCORRECT_VALUE_FORMAT = "Incorrect value format.";
    private static final String PAIR_ADDED = "The pair has been added to the dictionary.";
    private String stringValidationResult;
    private Boolean isValidationResult;

    public String getStringValidationResult() {
        return stringValidationResult;
    }

    public Boolean getIsValidationResult() {
        return isValidationResult;
    }

    public ValidationResult(Boolean isKey, Boolean isValue) {
        this.stringValidationResult = getStringResultValidation(isKey, isValue);
        this.isValidationResult = getBooleanResultValidation(isKey, isValue);
    }

    private String getStringResultValidation(Boolean isKey, Boolean isValue) {
        if (isKey && isValue) {
            return PAIR_ADDED;
        } else if (!isKey && !isValue) {
            return INCORRECT_KEY_AND_VALUE_FORMAT;
        } else if (!isKey) {
            return INCORRECT_KEY_FORMAT;
        } else {
            return INCORRECT_VALUE_FORMAT;
        }
    }

    private Boolean getBooleanResultValidation(Boolean isKey, Boolean isValue) {
        if (isKey && isValue) {
            return true;
        } else {
            return false;
        }
    }
}

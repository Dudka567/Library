package src.main.java.controller.validators;

import java.util.regex.Pattern;

public class LibraryValidator implements Validator {
    private static final String INCORRECT_KEY_AND_VALUE_FORMAT = "Incorrect key and value format.";
    private static final String INCORRECT_KEY_FORMAT = "Incorrect key format.";
    private static final String INCORRECT_VALUE_FORMAT = "Incorrect value format.";
    private static final String PAIR_ADDED = "The pair has been added to the dictionary.";
    private Pattern patternKey;
    private Pattern patternValue;

    public LibraryValidator(String patternKey, String patternValue) {
        this.patternKey = Pattern.compile(patternKey);
        this.patternValue = Pattern.compile(patternValue);
    }

    @Override
    public ValidationResult validatePair(String key, String value) {
        boolean boolResultValidation = false;
        ValidationResult validationResult;
        if (boolResultValidation = (patternKey.matcher(key).matches() && patternValue.matcher(value).matches())) {
            validationResult = new ValidationResult(PAIR_ADDED, boolResultValidation);
        } else if (boolResultValidation = (!patternKey.matcher(key).matches() && patternValue.matcher(value).matches())) {
            validationResult = new ValidationResult(INCORRECT_KEY_AND_VALUE_FORMAT, boolResultValidation);
        } else if (boolResultValidation = (!patternKey.matcher(key).matches())) {
            validationResult = new ValidationResult(INCORRECT_KEY_FORMAT, boolResultValidation);
        } else {
            validationResult = new ValidationResult(INCORRECT_VALUE_FORMAT, boolResultValidation);
        }
        return validationResult;
    }
}

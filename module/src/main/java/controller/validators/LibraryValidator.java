package src.main.java.controller.validators;

import java.util.regex.Pattern;

public class LibraryValidator implements Validator {
    private static final String INCORRECT_KEY_OR_VALUE_FORMAT = "Incorrect key or value format.";
    private Pattern patternKey;
    private Pattern patternValue;

    public LibraryValidator(String patternKey, String patternValue) {
        this.patternKey = Pattern.compile(patternKey);
        this.patternValue = Pattern.compile(patternValue);
    }

    @Override
    public ValidationResult validatePair(String key, String value) {
        ValidationResult validationResult;
        boolean isValidKey = patternKey.matcher(key).matches();
        boolean isValidValue = patternValue.matcher(value).matches();

        if (isValidKey && isValidValue) {
            validationResult = new ValidationResult(true);
        } else  {
            validationResult = new ValidationResult(INCORRECT_KEY_OR_VALUE_FORMAT, false);
        }

        return validationResult;
    }
}

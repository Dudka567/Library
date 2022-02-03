package src.main.java.controller.validators;

import java.util.regex.Pattern;

public class LibraryValidator implements Validator {
    private Pattern patternKey;
    private Pattern patternValue;

    public LibraryValidator(String patternKey, String patternValue) {
        this.patternKey = Pattern.compile(patternKey);
        this.patternValue = Pattern.compile(patternValue);
    }

    @Override
    public ValidationResult validatePair(String key, String value) {
        ValidationResult validationResult = new ValidationResult(patternKey.matcher(key).matches(), patternValue.matcher(value).matches());
        return validationResult;
    }
}

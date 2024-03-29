package com.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LibraryValidator implements Validator{
    private static final String INCORRECT_KEY_FORMAT = "Неправильный шаблон ключа";
    private static final String INCORRECT_VALUE_FORMAT = "Неправильный шаблон значения";
    private final Pattern patternKey;
    private final Pattern patternValue;

    public LibraryValidator(String patternKey, String patternValue) {
        this.patternKey = Pattern.compile(patternKey);
        this.patternValue = Pattern.compile(patternValue);
    }

    @Override
    public ValidationResult validatePair(String key, String value) {
        ValidationResult validationResult;
        List<String> errorsMessages = new ArrayList<>();

        boolean isValidKey = patternKey.matcher(key).matches();
        boolean isValidValue = patternValue.matcher(value).matches();

        if (!isValidKey) {
            errorsMessages.add(INCORRECT_KEY_FORMAT);
        }
        if (!isValidValue) {
            errorsMessages.add(INCORRECT_VALUE_FORMAT);
        }

        validationResult = new ValidationResult(errorsMessages);

        return validationResult;
    }

}

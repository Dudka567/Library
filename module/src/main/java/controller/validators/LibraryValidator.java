package src.main.java.controller.validators;

import lombok.NonNull;

import java.util.regex.Pattern;

public class LibraryValidator implements Validator {
    @NonNull
    private Pattern patternKey;
    @NonNull
    private Pattern patternValue;

    public LibraryValidator(String patternKey, String patternValue) {
        this.patternKey = Pattern.compile(patternKey);
        this.patternValue = Pattern.compile(patternValue);
    }

    @Override
    public boolean isValidateKey(String key) {
        return patternKey.matcher(key).matches();
    }

    @Override
    public boolean isValidateValue(String value) {
        return patternValue.matcher(value).matches();
    }


}

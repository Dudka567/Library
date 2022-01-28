package src.main.java;

import java.util.regex.Pattern;

public class LibraryValidator implements ValidatorOfPatterns {
    private Pattern patternKey;
    private Pattern patternValue;

    public LibraryValidator(String patternKey, String patternValue) {
        this.patternKey = Pattern.compile(patternKey);
        this.patternValue = Pattern.compile(patternValue);
    }

    @Override
    public boolean isValidateKey(String key) {
        System.out.println(patternKey.matcher(key).matches());
        return patternKey.matcher(key).matches();
    }

    @Override
    public boolean isValidateValue(String value) {
        System.out.println(patternValue.matcher(value).matches());
        return patternValue.matcher(value).matches();
    }


}

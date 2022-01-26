package src.main.javaFiles;

import java.util.regex.Pattern;

public class ValidatorOfPatterns implements ValidatorOfPatternsFunctionally{
    private Pattern patternKey;
    private Pattern patternValue;

    public ValidatorOfPatterns(String patternKey, String patternValue) {
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

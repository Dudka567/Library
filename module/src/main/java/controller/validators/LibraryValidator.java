package src.main.java.controller.validators;

import java.util.regex.Pattern;

public class LibraryValidator implements Validator {
    private static final String[] errorMessages = {"Incorrect key format.", "Incorrect value format."};
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

        boolean[] resultsValidation = {isValidKey, isValidValue};
        String errorsValidation = "";
        boolean isSuccessfully = true;

        for(int countElem = 0; countElem < resultsValidation.length; countElem++)
        {
            if(!resultsValidation[countElem])
            {
                errorsValidation += errorMessages[countElem];
                isSuccessfully = false;
            }
        }

        validationResult = new ValidationResult(errorsValidation, isSuccessfully);

        return validationResult;
    }

}

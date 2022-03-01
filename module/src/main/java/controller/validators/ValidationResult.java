package src.main.java.controller.validators;

import java.util.List;

public class ValidationResult {
    private List<String> stringValidationResult;

    public String getStringValidationResult() {
        return String.join(", ", stringValidationResult);
    }

    public Integer getNumberErrors() {
        return stringValidationResult.size();
    }

    public ValidationResult(List<String> stringValidationResult) {
        this.stringValidationResult = stringValidationResult;
    }

}

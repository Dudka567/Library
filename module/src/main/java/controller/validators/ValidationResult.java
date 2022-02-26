package src.main.java.controller.validators;

public class ValidationResult {
    private String stringValidationResult;
    private Boolean isValidationResult;

    public String getStringValidationResult() {
        return stringValidationResult;
    }

    public Boolean getIsValidationResult() {
        return isValidationResult;
    }

    public ValidationResult(String stringValidationResult, Boolean isValidationResult) {
        this.stringValidationResult = stringValidationResult;
        this.isValidationResult = isValidationResult;
    }

}

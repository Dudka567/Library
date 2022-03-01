package src.main.java.controller.validators;

import java.util.List;

public class ValidationResult {
    private List<String> errorsValidation;

    public String getValidationResult() {
        return String.join(", ", errorsValidation);
    }

    public Integer getNumberErrors() {
        return errorsValidation.size();
    }

    public ValidationResult(List<String> errorsValidation) {
        this.errorsValidation = errorsValidation;
    }

}

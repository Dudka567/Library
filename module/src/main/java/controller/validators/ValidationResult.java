package src.main.java.controller.validators;

import java.util.List;

public class ValidationResult {
    private List<String> errorsValidation;

    public List<String> getErrorsValidation() {
        return errorsValidation;
    }

    public boolean isValid() {
       return getErrorsValidation().isEmpty();
    }

    public ValidationResult(List<String> errorsValidation) {
        this.errorsValidation = errorsValidation;
    }

}

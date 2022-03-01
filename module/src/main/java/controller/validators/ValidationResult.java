package src.main.java.controller.validators;

import java.util.List;

public class ValidationResult {
    private List<String> errorsValidation;

    public String getValidationResult() {
        return String.join(", ", errorsValidation);
    }

    public boolean isValid() {
        if (errorsValidation.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public ValidationResult(List<String> errorsValidation) {
        this.errorsValidation = errorsValidation;
    }

}

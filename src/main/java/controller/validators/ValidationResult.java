package controller.validators;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
    private List<String> errorsValidation;

    public List<String> getErrorsValidation() {
        if (errorsValidation == null) {
           errorsValidation = new ArrayList<>();
        }
            return errorsValidation;
    }

    public boolean isValid() {
        return getErrorsValidation().isEmpty();
    }

    public ValidationResult(List<String> errorsValidation) {
        this.errorsValidation = errorsValidation;
    }

}
package controller.validators;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class ValidationResult {
    @Getter
    private List<String> errorsValidation;

    public boolean isValid() {
        return getErrorsValidation().isEmpty();
    }

}
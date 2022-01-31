package src.main.java.controller.validators;

public class ResultValidation {
    private static final String INCORRECT_KEY_AND_VALUE_FORMAT = "Incorrect key and value format.";
    private static final String INCORRECT_KEY_FORMAT = "Incorrect key format.";
    private static final String INCORRECT_VALUE_FORMAT = "Incorrect value format.";
    private static final String PAIR_ADDED = "The pair has been added to the dictionary.";

    public String getStringResultValidation(boolean isKey, boolean isValue) {
        if (isKey && isValue) {
            return PAIR_ADDED;
        } else if (!isKey && !isValue) {
            return INCORRECT_KEY_AND_VALUE_FORMAT;
        } else if (!isKey) {
            return INCORRECT_KEY_FORMAT;
        } else {
            return INCORRECT_VALUE_FORMAT;
        }
    }

    public boolean getBooleanResultValidation(boolean isKey, boolean isValue) {
        if (isKey && isValue) {
            return true;
        } else {
            return false;
        }
    }
}

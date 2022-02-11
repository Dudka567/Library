package controller;

import controller.validators.ResultValidation;
import controller.validators.Validator;
import model.Storage;

import java.util.LinkedHashMap;
import java.util.Map;

public class FileLibrary implements Library {
    private static final String PAIR_MISSING = "The pair is missing from the dictionary.";
    private static final String PAIR_DELETED = "The pair has been deleted to the dictionary.";
    private static final String PAIR_SEARCHED = "Value: ";

    private Storage mainLibraryStorage;
    private Validator mainValidator;

    private Map<String, String> localDictionary;

    private String nameLibrary;

    public FileLibrary(Validator mainValidator, String nameLibrary, Storage mainLibraryStorage) {
        this.mainValidator = mainValidator;
        this.nameLibrary = nameLibrary;
        this.mainLibraryStorage = mainLibraryStorage;
        localDictionary = new LinkedHashMap<>();
        mainLibraryStorage.readStorage(getLocalDictionary());
    }

    @Override
    public Map<String, String> getLocalDictionary() {
        return localDictionary;
    }

    @Override
    public String getNameLibrary() {
        return nameLibrary;
    }

    @Override
    public void readPairs() {
        mainLibraryStorage.readStorage(getLocalDictionary());
    }

    @Override
    public String deletePair(String key) {
        mainLibraryStorage.readStorage(getLocalDictionary());
        localDictionary.remove(key);
        mainLibraryStorage.writeStorage(getLocalDictionary());
        return PAIR_DELETED;
    }

    @Override
    public String searchPair(String key) {
        mainLibraryStorage.readStorage(getLocalDictionary());
        return localDictionary.get(key).equals("null") ? PAIR_MISSING : PAIR_SEARCHED + localDictionary.get(key);
    }

    @Override
    public String addPair(String key, String value) {

        mainLibraryStorage.readStorage(getLocalDictionary());
        ResultValidation localResultValidation = new ResultValidation();
        String answer = localResultValidation.getStringResultValidation(mainValidator.isValidateKey(key), mainValidator.isValidateValue(value));

        if (localResultValidation.getBooleanResultValidation(mainValidator.isValidateKey(key), mainValidator.isValidateValue(value))) {
            localDictionary.put(key, value);
            mainLibraryStorage.writeStorage(localDictionary);
        }

        return answer;
    }
}

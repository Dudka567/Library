package src.main.java.controller;

import src.main.java.controller.validators.ValidationResult;
import src.main.java.controller.validators.Validator;
import src.main.java.model.Storage;

import java.util.LinkedHashMap;
import java.util.Map;

public class FileLibrary implements Library {
    private static final String PAIR_MISSING = "The pair is missing from the dictionary.";
    private static final String PAIR_DELETED = "The pair has been deleted to the dictionary.";
    private static final String PAIR_ADDED = "The pair has been added to the dictionary.";
    private static final String PAIR_SEARCHED = "Value: ";

    private Storage mainLibraryStorage;
    private Validator mainValidator;

    private Map<String, String> localDictionary;

    private String nameLibrary;
    private String typeLibrary;

    public FileLibrary(Validator mainValidator, String nameLibrary, String typeLibrary, Storage mainLibraryStorage) {
        this.mainValidator = mainValidator;
        this.nameLibrary = nameLibrary;
        this.typeLibrary = typeLibrary;
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
        return checkPair(key);
    }

    private String checkPair(String key)
    {
        return (localDictionary.get(key) != null && !localDictionary.get(key).isEmpty()) ? PAIR_SEARCHED + localDictionary.get(key) : PAIR_MISSING;
    }

    @Override
    public String addPair(String key, String value) {
        mainLibraryStorage.readStorage(getLocalDictionary());
        ValidationResult localResultValidation = mainValidator.validatePair(key, value);

        if (localResultValidation.getNumberErrors() == 0) {
            localDictionary.put(key, value);
            mainLibraryStorage.writeStorage(localDictionary);
            return PAIR_ADDED;
        }

        return localResultValidation.getValidationResult();
    }
}

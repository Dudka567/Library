package controller;

import controller.validators.ValidationResult;
import controller.validators.Validator;
import model.Storage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class FileLibrary implements Library {
    private static final String PAIR_MISSING = "The pair is missing from the dictionary.";
    private static final String PAIR_DELETED = "The pair has been deleted to the dictionary.";
    private static final String PAIR_ADDED = "The pair has been added to the dictionary.";
    private static final String PAIR_SEARCHED = "Value: ";

    private final Storage mainLibraryStorage;
    private final Validator mainValidator;
    private final Map<String, String> localDictionary;
    private final String nameLibrary;

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
        return checkPair(key);
    }

    private String checkPair(String key) {
        return (localDictionary.get(key) != null && !localDictionary.get(key).isEmpty()) ? PAIR_SEARCHED + localDictionary.get(key) : PAIR_MISSING;
    }

    @Override
    public List<String> addPair(String key, String value) {

        mainLibraryStorage.readStorage(getLocalDictionary());
        ValidationResult localResultValidation = mainValidator.validatePair(key, value);
        List<String> resultAddedPairs = new ArrayList<>();

        if (localResultValidation.isValid()) {
            localDictionary.put(key, value);
            mainLibraryStorage.writeStorage(localDictionary);
            resultAddedPairs.add(PAIR_ADDED);
        } else {
            resultAddedPairs = localResultValidation.getErrorsValidation();
        }

        return resultAddedPairs;
    }
}

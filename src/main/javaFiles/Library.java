package src.main.javaFiles;

import java.util.LinkedHashMap;
import java.util.Map;

public class Library implements LibraryFunctionally {
    private static final String PAIR_MISSING = "The pair is missing from the dictionary.";
    private static final String INCORRECT_KEY_AND_VALUE_FORMAT = "Incorrect key and value format.";
    private static final String INCORRECT_KEY_FORMAT = "Incorrect key format.";
    private static final String INCORRECT_VALUE_FORMAT = "Incorrect value format.";
    private static final String PAIR_ADDED = "The pair has been added to the dictionary.";
    private static final String PAIR_DELETED = "The pair has been deleted to the dictionary.";
    private static final String PAIR_SEARCHED = "Value: ";

    private StorageOfDictionariesFunctionally mainLibraryStorage;
    private ValidatorOfPatternsFunctionally mainLibraryValidator;

    private Map<String, String> localDictionary;

    private String nameLibrary;
    private String typeLibrary;

    public Library(ValidatorOfPatterns validatorOfPatterns, String nameLibrary, String typeLibrary, StorageOfDictionariesFunctionally mainLibraryStorage) {
        this.mainLibraryValidator = validatorOfPatterns;
        this.nameLibrary = nameLibrary;
        this.typeLibrary = typeLibrary;
        this.mainLibraryStorage = mainLibraryStorage;
        localDictionary = new LinkedHashMap<>();
        mainLibraryStorage.readStorage(getLocalDictionary());
    }

    public Map<String, String> getLocalDictionary() {
        return localDictionary;
    }

    public String getNameLibrary() {
        return nameLibrary;
    }

    public String getTypeLibrary() {
        return typeLibrary;
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

        if (mainLibraryValidator.isValidateKey(key) && mainLibraryValidator.isValidateValue(value)) {
            localDictionary.put(key, value);
            mainLibraryStorage.writeStorage(getLocalDictionary());
        } else if (!mainLibraryValidator.isValidateKey(key) && !mainLibraryValidator.isValidateValue(value))
            return INCORRECT_KEY_AND_VALUE_FORMAT;
        else if (!mainLibraryValidator.isValidateKey(key)) return INCORRECT_KEY_FORMAT;
        else if (!mainLibraryValidator.isValidateValue(value)) return INCORRECT_VALUE_FORMAT;

        return PAIR_ADDED;
    }
}

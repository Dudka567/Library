package src.main.javaFiles; 

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Library implements LibraryFunctionally {
    public static final String PAIR_MISSING = "The pair is missing from the dictionary.";
    public static final String INCORRECT_KEY_AND_VALUE_FORMAT = "Incorrect key and value format.";
    public static final String INCORRECT_KEY_FORMAT = "Incorrect key format.";
    public static final String INCORRECT_VALUE_FORMAT = "Incorrect value format.";
    public static final String PAIR_ADDED = "The pair has been added to the dictionary.";
    public static final String PAIR_DELETED = "The pair has been deleted to the dictionary.";
    public static final String PAIR_SEARCHED = "Value: ";

    private FileManager mainManager;

    private LinkedHashMap<String, String> localDictionary;

    private Pattern patternKey;
    private Pattern patternValue;


    private String nameLibrary;
    private String typeLibrary;

    public Library(String patternKey, String patternValue, String nameLibrary, String typeLibrary, FileManager mainManager) throws IOException {
        this.patternKey = Pattern.compile(patternKey);
        this.patternValue = Pattern.compile(patternValue);
        this.nameLibrary = nameLibrary;
        this.typeLibrary = typeLibrary;
        this.mainManager = mainManager;
        localDictionary = new LinkedHashMap<>();
        mainManager.readFile(this);
    }

    public LinkedHashMap<String, String> getLocalDictionary() {
        return localDictionary;
    }

    public String getNameLibrary() {
        return nameLibrary;
    }

    public String getTypeLibrary() {
        return typeLibrary;
    }

    @Override
    public void readPairs() throws IOException {
        mainManager.readFile(this);
    }

    @Override
    public String deletePair(String key) throws IOException {
        mainManager.readFile(this);
        localDictionary.remove(key);
        mainManager.writeFile(this);
        return PAIR_DELETED;
    }

    @Override
    public String searchPair(String key) throws IOException {
        mainManager.readFile(this);
        return localDictionary.get(key).equals("null") ? PAIR_MISSING : PAIR_SEARCHED + localDictionary.get(key);
    }

    @Override
    public String addPair(String key, String value) throws IOException {
        Matcher matcherKey = patternKey.matcher(key);
        Matcher matcherValue = patternValue.matcher(value);

        mainManager.readFile(this);
        if (matcherKey.matches() && matcherValue.matches()) {
            localDictionary.put(key, value);
            mainManager.writeFile(this);

        } else if (!matcherKey.matches() && !matcherValue.matches()) return INCORRECT_KEY_AND_VALUE_FORMAT;
        else if (!matcherKey.matches()) return INCORRECT_KEY_FORMAT;
        else if (!matcherValue.matches()) return INCORRECT_VALUE_FORMAT;

        return PAIR_ADDED;
    }
}

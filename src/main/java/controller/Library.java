package src.main.java.controller;

import src.main.java.model.Storage;

import java.util.Map;

public interface Library {
    void readPairs();

    String deletePair(String key);

    String searchPair(String key);

    String addPair(String key, String value);

    Map<String, String> getLocalDictionary();

    String getNameLibrary();

}

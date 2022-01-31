package src.main.java.controller;

import lombok.NonNull;

import java.util.Map;

public interface Library {
    void readPairs();

    String deletePair(String key);

    String searchPair(String key);

    String addPair(String key, String value);

    @NonNull
    Map<String, String> getLocalDictionary();

    String getNameLibrary();

}

package src.main.java.controller;
import java.util.List;
import java.util.Map;

public interface Library {
    void readPairs();

    String deletePair(String key);

    String searchPair(String key);

    List<String> addPair(String key, String value);

    Map<String, String> getLocalDictionary();

    String getNameLibrary();

}

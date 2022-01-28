package src.main.java;

import java.util.Map;

public interface StorageOfDictionaries {
    void readStorage(Map<String, String> library);

    void writeStorage(Map<String, String> library);

    String searchStorage(String expectedNameFile);

}

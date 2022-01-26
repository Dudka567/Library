package src.main.javaFiles; 

import java.io.IOException;
import java.util.Map;

public interface LibraryFunctionally {
    void readPairs() throws IOException;

    String deletePair(String key) throws IOException;

    String searchPair(String key) throws IOException;

    String addPair(String key, String value) throws IOException;

     Map<String, String> getLocalDictionary();

     String getNameLibrary();

     String getTypeLibrary();
}

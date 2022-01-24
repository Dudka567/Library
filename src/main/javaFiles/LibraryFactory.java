package src.main.javaFiles;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class LibraryFactory {
    private ConfigManager configManager;

    public LibraryFactory(ConfigManager configManager) {
        this.configManager = configManager;
    }


    public Map<String, LibraryFunctionally> createLibraries() throws IOException {
        LinkedHashMap<String, LibraryFunctionally> listLibraries = new LinkedHashMap<>();
        for (ConfigManager.DictionaryConfig dictionaryConfig : configManager.readConfig()) {
            listLibraries.put(dictionaryConfig.typeDictionary, new Library(dictionaryConfig.patternKey, dictionaryConfig.patternValue, dictionaryConfig.nameDictionary, dictionaryConfig.typeDictionary, new FileManager(configManager.searchLibrary(dictionaryConfig.typeDictionary))));
        }
        return (LinkedHashMap<String, LibraryFunctionally>) listLibraries.clone();
    }

}

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
            listLibraries.put(dictionaryConfig.getTypeDictionary(), new Library(dictionaryConfig.getPatternKey(), dictionaryConfig.getPatternValue(), dictionaryConfig.getNameDictionary(), dictionaryConfig.getTypeDictionary(), new FileManager(configManager.searchLibrary(dictionaryConfig.getTypeDictionary()))));
        }
        return (LinkedHashMap<String, LibraryFunctionally>) listLibraries.clone();
    }

}

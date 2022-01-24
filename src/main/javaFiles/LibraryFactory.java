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
        for (ConfigManager.DataDictionary arg : configManager.readConfig()) {
            listLibraries.put(arg.typeDictionary, new Library(arg.patternKey, arg.patternValue, arg.nameDictionary, arg.typeDictionary, new FileManager(configManager.searchLibrary(arg.typeDictionary))));
        }
        return (LinkedHashMap<String, LibraryFunctionally>) listLibraries.clone();
    }

}

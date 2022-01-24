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
        for (String[] arg : configManager.readConfig()) {
            listLibraries.put(arg[3], new Library(arg[0], arg[1], arg[2], arg[3], new FileManager(configManager.searchLibrary(arg[3]))));
        }
        return (LinkedHashMap<String, LibraryFunctionally>) listLibraries.clone();
    }

}

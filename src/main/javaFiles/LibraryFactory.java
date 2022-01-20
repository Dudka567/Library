package src.main.javaFiles; 

import java.io.IOException;
import java.util.LinkedHashMap;


public class LibraryFactory implements LibraryFactoryFunctionally {
    private ConfigManagerFunctionally configManager;

    public LibraryFactory() {
        configManager = new ConfigManager();
    }


    @Override
    public LinkedHashMap<String, Library> createLibraries() throws IOException {
        LinkedHashMap<String, Library> listLibraries = new LinkedHashMap<>();
        for (String[] arg : configManager.readConfig()) {
            listLibraries.put(arg[3], new Library(arg[0], arg[1], arg[2], arg[3], new FileManager(configManager.searchLibrary(arg[3]))));
        }
        return listLibraries;
    }

}

package src.main.java;

import java.util.LinkedHashMap;
import java.util.Map;


public class LibraryFactory {
    private Config config;

    public LibraryFactory(Config config) {
        this.config = config;
    }


    public Map<String, Library> createLibraries() {
        FileLibrary tempFileLibrary;
        LibraryValidator tempValidator;
        FilesStorageOfDictionaries tempStorage;

        Map<String, Library> listLibraries = new LinkedHashMap<>();
        for (Config.DictionaryConfig dictionaryConfig : config.readConfig()) {
            tempStorage = new FilesStorageOfDictionaries(dictionaryConfig.getTypeDictionary());
            tempValidator = new LibraryValidator(
                    dictionaryConfig.getPatternKey(),
                    dictionaryConfig.getPatternValue());
            tempFileLibrary = new FileLibrary(
                    tempValidator,
                    dictionaryConfig.getNameDictionary(),
                    dictionaryConfig.getTypeDictionary(),
                    tempStorage);



            listLibraries.put(dictionaryConfig.getTypeDictionary(), tempFileLibrary);
        }
        return listLibraries;

    }


}

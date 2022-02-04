package src.main.java.infrastructure;

import src.main.java.controller.validators.LibraryValidator;
import src.main.java.controller.FileLibrary;
import src.main.java.controller.validators.Validator;
import src.main.java.model.FilesStorage;
import src.main.java.controller.Library;


import java.util.LinkedHashMap;
import java.util.Map;


public class LibraryFactory {
    private Config config;

    public LibraryFactory(Config config) {
        this.config = config;
    }


    public Map<String, Library> createLibraries() {
        FileLibrary tempFileLibrary;
        Validator tempValidator;
        FilesStorage tempStorage;

        Map<String, Library> libraries = new LinkedHashMap<>();
        for (Config.DictionaryConfig dictionaryConfig : config.readConfig()) {
            tempStorage = new FilesStorage(dictionaryConfig.getTypeDictionary());
            tempValidator = new LibraryValidator(
                    dictionaryConfig.getPatternKey(),
                    dictionaryConfig.getPatternValue());
            tempFileLibrary = new FileLibrary(
                    tempValidator,
                    dictionaryConfig.getNameDictionary(),
                    dictionaryConfig.getTypeDictionary(),
                    tempStorage);


            libraries.put(dictionaryConfig.getNameDictionary(), tempFileLibrary);
        }
        return libraries;

    }


}

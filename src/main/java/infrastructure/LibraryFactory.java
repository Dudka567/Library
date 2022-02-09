package infrastructure;

import controller.validators.LibraryValidator;
import controller.FileLibrary;
import controller.validators.Validator;
import model.FilesStorage;
import controller.Library;


import java.util.LinkedHashMap;
import java.util.Map;


public class LibraryFactory {
    private Config config;
    private final Integer COUNTER_LIBRARY = 1;

    public LibraryFactory(Config config) {
        this.config = config;
    }


    public Map<String, Library> createLibraries() {
        Integer counter = COUNTER_LIBRARY;
        FileLibrary tempFileLibrary;
        Validator tempValidator;
        FilesStorage tempStorage;

        Map<String, Library> listLibraries = new LinkedHashMap<>();
        for (Config.DictionaryConfig dictionaryConfig : config.readConfig()) {
            tempStorage = new FilesStorage(dictionaryConfig.getPathDictionary());
            tempValidator = new LibraryValidator(
                    dictionaryConfig.getPatternKey(),
                    dictionaryConfig.getPatternValue());
            tempFileLibrary = new FileLibrary(
                    tempValidator,
                    dictionaryConfig.getNameDictionary(),
                    dictionaryConfig.getPathDictionary(),
                    tempStorage);

            listLibraries.put(String.valueOf(counter), tempFileLibrary);
            counter++;
        }
        return listLibraries;

    }


}

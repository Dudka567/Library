package infrastructure;

import controller.validators.LibraryValidator;
import controller.FileLibrary;
import controller.validators.Validator;
import model.FilesStorage;
import controller.Library;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class LibraryFactory {
    private Config config;
    private final Integer APPEND_COUNTER = 1;

    public LibraryFactory(Config config) {
        this.config = config;
    }


    public Map<String, Library> createLibraries() {
        FileLibrary tempFileLibrary;
        Validator tempValidator;
        FilesStorage tempStorage;

        Map<String, Library> listLibraries = new LinkedHashMap<>();
        List<Config.DictionaryConfig> configData = config.readConfig();

        for (int counter = 0; counter < configData.size(); counter++) {
            tempStorage = new FilesStorage(configData.get(counter).getPathDictionary());
            tempValidator = new LibraryValidator(
                    configData.get(counter).getPatternKey(),
                    configData.get(counter).getPatternValue());
            tempFileLibrary = new FileLibrary(
                    tempValidator,
                    configData.get(counter).getNameDictionary(),
                    tempStorage);

            listLibraries.put(String.valueOf(counter + APPEND_COUNTER), tempFileLibrary);
        }

        return listLibraries;

    }


}

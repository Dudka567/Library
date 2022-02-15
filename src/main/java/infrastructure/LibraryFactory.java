package infrastructure;

import controller.validators.LibraryValidator;
import controller.FileLibrary;
import controller.validators.Validator;
import model.FilesStorage;
import controller.Library;


import java.util.ArrayList;
import java.util.List;


public class LibraryFactory {
    private Config config;

    public LibraryFactory(Config config) {
        this.config = config;
    }


    public List<Library> createLibraries() {
        FileLibrary tempFileLibrary;
        Validator tempValidator;
        FilesStorage tempStorage;

        List<Library> listLibraries = new ArrayList<>();
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

            listLibraries.add(tempFileLibrary);
        }

        return listLibraries;

    }


}

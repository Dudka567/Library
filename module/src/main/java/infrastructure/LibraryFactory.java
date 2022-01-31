package src.main.java.infrastructure;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import src.main.java.controller.validators.LibraryValidator;
import src.main.java.controller.FileLibrary;
import src.main.java.controller.validators.Validator;
import src.main.java.model.FilesStorage;
import src.main.java.controller.Library;


import java.util.LinkedHashMap;
import java.util.Map;

@AllArgsConstructor
@NonNull
public class LibraryFactory {
    private Config config;

    public @NonNull Map<String, Library> createLibraries() {
        FileLibrary tempFileLibrary;
        Validator tempValidator;
        FilesStorage tempStorage;

        Map<String, Library> listLibraries = new LinkedHashMap<>();
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


            listLibraries.put(dictionaryConfig.getTypeDictionary(), tempFileLibrary);
        }
        return listLibraries;

    }


}

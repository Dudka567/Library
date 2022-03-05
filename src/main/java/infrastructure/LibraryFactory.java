package infrastructure;

import controller.FileLibrary;
import controller.validators.LibraryValidator;
import controller.validators.Validator;
import lombok.AllArgsConstructor;
import model.FilesStorage;
import controller.Library;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class LibraryFactory {
    private Config config;

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

    public List<String> createNamesDictionaries() {
        List<Config.DictionaryConfig> configData = config.readConfig();
        List<String> namesDictionaries = new ArrayList<>();

        for (Config.DictionaryConfig aboutDictionary : configData) {
            namesDictionaries.add(aboutDictionary.getNameDictionary());
        }
        return namesDictionaries;
    }


}

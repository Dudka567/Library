package src.main.javaFiles;

import java.util.LinkedHashMap;
import java.util.Map;


public class LibraryFactory {
    private Config config;

    public LibraryFactory(Config config) {
        this.config = config;
    }


    public Map<String, LibraryFunctionally> createLibraries() {

        Map<String, LibraryFunctionally> listLibraries = new LinkedHashMap<>();
        for (Config.DictionaryConfig dictionaryConfig : config.readConfig()) {
            listLibraries.put(dictionaryConfig.getTypeDictionary(), new Library(new ValidatorOfPatterns(dictionaryConfig.getPatternKey(), dictionaryConfig.getPatternValue()), dictionaryConfig.getNameDictionary(), dictionaryConfig.getTypeDictionary(), new StorageOfDictionaries(dictionaryConfig.getTypeDictionary())));
        }
        return listLibraries;

    }


}

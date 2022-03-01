package infrastructure;

import controller.Library;
import java.util.ArrayList;
import java.util.List;

public class TypesLibraryFactory {
    private List<Library> dictionaries;

    public TypesLibraryFactory(List<Library> dictionaries) {
        this.dictionaries = dictionaries;
    }

    private List<Library> getDictionaries() {
        return dictionaries;
    }

    public List<String> createTypesLibrary() {
        List<String> namesDictionaries = new ArrayList<>();
        for (Library dictionary : getDictionaries()) {
            namesDictionaries.add(dictionary.getNameLibrary());
        }
        return namesDictionaries;
    }
}

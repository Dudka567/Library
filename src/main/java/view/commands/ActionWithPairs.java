package view.commands;

import controller.Library;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionWithPairs {
    @Setter
    protected Integer position;
    protected Map<String, Library> dictionaries;

    public ActionWithPairs(List<Library> dictionaries) {
        this.dictionaries = new HashMap<>();
        initDictionaries(dictionaries);
    }

    public void initDictionaries(List<Library> dictionaries) {
        for (Library library : dictionaries) {
            this.dictionaries.put(library.getNameLibrary(), library);
        }
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

}

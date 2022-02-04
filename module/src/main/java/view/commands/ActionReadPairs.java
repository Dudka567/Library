package src.main.java.view.commands;

import src.main.java.view.menu.ConsoleConstants;
import src.main.java.controller.Library;

import java.util.Map;

public class ActionReadPairs implements Action {
    private final String TITLE = ".Show the contents of the dictionary\n";
    private Integer position;
    Map<String, Library> dictionaries;

    public ActionReadPairs(Map<String, Library> dictionaries) {
        this.dictionaries = dictionaries;
    }

    @Override
    public String getTitle() {
        return TITLE;
    }

    @Override
    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public Integer getPosition() {
        return position;
    }

    @Override
    public void execute(String typeLibrary) {
        dictionaries.get(typeLibrary).readPairs();
        for (String lineKey : dictionaries.get(typeLibrary).getLocalDictionary().keySet()) {
            System.out.println(ConsoleConstants.KEY + lineKey + ConsoleConstants.CHAR_SPACE + ConsoleConstants.VALUE + dictionaries.get(typeLibrary).getLocalDictionary().get(lineKey));
        }
    }
}

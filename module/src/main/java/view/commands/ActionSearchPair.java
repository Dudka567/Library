package src.main.java.view.commands;

import src.main.java.view.menu.ConsoleConstants;
import src.main.java.controller.Library;

import java.util.Map;

public class ActionSearchPair implements Action {
    private final String TITLE = ".Search records by key\n";
    private Integer position;
    private Map<String, Library> dictionaries;

    public ActionSearchPair(Map<String, Library> dictionaries) {
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
        System.out.print(ConsoleConstants.INPUT_KEY);
        String tempKey = ConsoleConstants.user.next();
        System.out.println(dictionaries.get(typeLibrary).searchPair(tempKey));
    }
}

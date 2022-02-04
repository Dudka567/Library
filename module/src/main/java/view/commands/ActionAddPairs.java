package src.main.java.view.commands;

import src.main.java.view.menu.ConsoleConstants;
import src.main.java.controller.Library;

import java.util.Map;

public class ActionAddPairs implements Action {
    private final String TITLE = ".Add an entry\n";
    private Integer position;
    private Map<String, Library> dictionaries;

    public ActionAddPairs(Map<String, Library> dictionaries) {
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
        System.out.print(ConsoleConstants.INPUT_VALUE);
        String tempValue = ConsoleConstants.user.next();
        System.out.println(dictionaries.get(typeLibrary).addPair(tempKey, tempValue));
    }
}

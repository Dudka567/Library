package view.commands;

import controller.Library;
import view.menu.ConsoleConstants;

import java.util.List;

public class ActionSearchPair extends ActionWithPairs implements Action {
    private static final String TITLE = ".Search records by key\n";

    public ActionSearchPair(List<Library> dictionaries) {
        super(dictionaries);
    }

    @Override
    public String getTitle() {
        return super.position + TITLE;
    }

    @Override
    public void setPosition(Integer position) {
        super.setPosition(position);
    }

    @Override
    public void execute(String typeLibrary) {
        System.out.print(ConsoleConstants.INPUT_KEY);
        String tempKey = ConsoleConstants.user.next();
        System.out.println(super.dictionaries.get(typeLibrary).searchPair(tempKey));
    }
}

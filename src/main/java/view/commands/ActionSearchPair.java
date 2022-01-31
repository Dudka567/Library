package src.main.java.view.commands;

import src.main.java.view.menu.ConsoleConstants;
import src.main.java.controller.Library;

public class ActionSearchPair implements Action {
    private final String INFO = "4.Search records by key\n";

    @Override
    public String getINFO() {
        return INFO;
    }

    @Override
    public void execute(Object actionObject) {
        Library library = (Library) actionObject;
        System.out.print(ConsoleConstants.INPUT_KEY);
        String tempKey = ConsoleConstants.user.next();
        System.out.println(library.searchPair(tempKey));
    }
}

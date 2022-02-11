package view.commands;

import view.menu.ConsoleConstants;
import controller.Library;

public class ActionAddPairs implements Action {
    private final String INFO = "2.Add an entry\n";

    @Override
    public String getINFO() {
        return INFO;
    }

    @Override
    public void execute(Object actionObject) {
        Library library = (Library) actionObject;
        System.out.print(ConsoleConstants.INPUT_KEY);
        String tempKey = ConsoleConstants.user.next();
        System.out.print(ConsoleConstants.INPUT_VALUE);
        String tempValue = ConsoleConstants.user.next();
        System.out.println(library.addPair(tempKey, tempValue));
    }
}
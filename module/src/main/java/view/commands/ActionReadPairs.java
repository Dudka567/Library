package src.main.java.view.commands;

import src.main.java.view.menu.ConsoleConstants;
import src.main.java.controller.Library;

public class ActionReadPairs implements Action {
    private final String INFO = "1.Show the contents of the dictionary\n";

    @Override
    public String getINFO() {
        return INFO;
    }

    @Override
    public void execute(Object actionObject) {
        Library library = (Library) actionObject;
        library.readPairs();
        for (String lineKey : library.getLocalDictionary().keySet()) {
            System.out.println(ConsoleConstants.KEY + lineKey + ConsoleConstants.CHAR_SPACE + ConsoleConstants.VALUE + library.getLocalDictionary().get(lineKey));
        }
    }
}

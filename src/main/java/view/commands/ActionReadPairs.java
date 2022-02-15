package view.commands;

import view.menu.ConsoleConstants;
import controller.Library;

import java.util.List;
import java.util.Map;

public class ActionReadPairs extends ActionWithPairs implements Action {
    private final String TITLE = ".Show the contents of the dictionary\n";

    public ActionReadPairs(List<Library> dictionaries) {
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
        dictionaries.get(typeLibrary).readPairs();
        for (String lineKey : dictionaries.get(typeLibrary).getLocalDictionary().keySet()) {
            System.out.println(ConsoleConstants.KEY + lineKey + ConsoleConstants.CHAR_SPACE + ConsoleConstants.VALUE + dictionaries.get(typeLibrary).getLocalDictionary().get(lineKey));
        }
    }
}

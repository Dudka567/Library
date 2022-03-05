package view.commands;

import view.menu.ConsoleConstants;
import controller.Library;

import java.util.List;
import java.util.Map;

public class ActionAddPairs extends ActionWithPairs implements Action {
    private final String TITLE = ".Add an entry\n";

    public ActionAddPairs(List<Library> dictionaries) {
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
        System.out.print(ConsoleConstants.INPUT_VALUE);
        String tempValue = ConsoleConstants.user.next();
        String resultAction = String.join(", ",super.dictionaries.get(typeLibrary).addPair(tempKey, tempValue));
        System.out.println(resultAction);
    }
}

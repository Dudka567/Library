package view.commands;

import view.menu.ConsoleConstants;
import controller.Library;

import java.util.List;
import java.util.Map;

public class ActionDeletePairs extends ActionWithPairs implements Action {
    private final String TITLE = ".Delete an entry\n";

    public ActionDeletePairs(List<Library> dictionaries) {
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
        System.out.println(super.dictionaries.get(typeLibrary).deletePair(tempKey));
    }
}
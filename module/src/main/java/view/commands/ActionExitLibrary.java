package src.main.java.view.commands;

import lombok.NonNull;
import src.main.java.controller.Library;

public class ActionExitLibrary implements Action {
    private final String INFO = "5.Finish working with this dictionary\n";
    private final String END_WORK = "Finished work with ";

    @Override
    public String getINFO() {
        return INFO;
    }

    public void execute(@NonNull Object actionObject) {
        Library library = (Library) actionObject;
        System.out.println(END_WORK + library.getNameLibrary());
    }
}

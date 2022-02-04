package src.main.java.view.commands;

import src.main.java.controller.Library;

import java.util.Map;

public class ActionExitLibrary implements Action {
    private final String TITLE = ".Finish working with this dictionary\n";
    private final String END_WORK = "Finished work with ";
    private Integer position;
    Map<String, Library> dictionaries;

    public ActionExitLibrary(Map<String, Library> dictionaries) {
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

    public void execute(String typeLibrary) {
        System.out.println(END_WORK + dictionaries.get(typeLibrary).getNameLibrary());
    }
}

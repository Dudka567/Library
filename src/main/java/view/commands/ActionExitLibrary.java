package view.commands;

import controller.Library;

import java.util.List;

public class ActionExitLibrary extends ActionWithPairs implements Action {
    private final String TITLE = ".Finish working with this dictionary\n";
    private final String END_WORK = "Finished work with ";

    public ActionExitLibrary(List<Library> dictionaries) {
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
        System.out.println(END_WORK + super.dictionaries.get(typeLibrary).getNameLibrary());
    }
}

package src.main.java;

import src.main.java.view.menu.ConsoleApp;
import src.main.java.infrastructure.Config;
import src.main.java.controller.Library;
import src.main.java.infrastructure.LibraryFactory;
import src.main.java.view.commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        Map<String, Library> dictionaries = libraryFactory.createLibraries();

        List<Action> actions = new ArrayList<>();
        List<String> libraries = new ArrayList<>(dictionaries.keySet());

        actions.add(new ActionReadPairs(dictionaries));
        actions.add(new ActionAddPairs(dictionaries));
        actions.add(new ActionDeletePairs(dictionaries));
        actions.add(new ActionSearchPair(dictionaries));
        actions.add(new ActionExitLibrary(dictionaries));


        ConsoleApp consoleApp = new ConsoleApp(libraries, actions);
        consoleApp.work();

    }
}

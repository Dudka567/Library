package src.main.java;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        Map<String, Library> listDictionaries = libraryFactory.createLibraries();
        Map<Integer, Action> listAction = new HashMap<>();

        listAction.put(1, new ActionReadPairs());
        listAction.put(2, new ActionAddPairs());
        listAction.put(3, new ActionDeletePairs());
        listAction.put(4, new ActionSearchPair());
        listAction.put(5, new ActionExitLibrary());


        ConsoleApp consoleApp = new ConsoleApp(listDictionaries, listAction);
        consoleApp.work();

    }
}

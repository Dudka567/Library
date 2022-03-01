import infrastructure.TypesLibraryFactory;
import view.menu.ConsoleApp;
import infrastructure.Config;
import controller.Library;
import infrastructure.LibraryFactory;
import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        List<Library> dictionaries = libraryFactory.createLibraries();

        TypesLibraryFactory typesFactory = new TypesLibraryFactory(dictionaries);
        List<String> typesDictionaries = typesFactory.createTypesLibrary();

        List<Action> actions = new ArrayList<>();

        actions.add(new ActionReadPairs(dictionaries));
        actions.add(new ActionAddPairs(dictionaries));
        actions.add(new ActionDeletePairs(dictionaries));
        actions.add(new ActionSearchPair(dictionaries));
        actions.add(new ActionExitLibrary(dictionaries));


        ConsoleApp consoleApp = new ConsoleApp(typesDictionaries, actions);
        consoleApp.work();

    }

}

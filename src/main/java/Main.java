import controller.Library;
import infrastructure.Config;
import infrastructure.LibraryFactory;
import view.commands.*;
import view.menu.ConsoleApp;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        List<Library> dictionaries = libraryFactory.createLibraries();
        List<String> typesDictionaries = libraryFactory.createNamesDictionaries();

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

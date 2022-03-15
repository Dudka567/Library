import controller.Library;
import infrastructure.LibraryFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.commands.*;
import view.menu.ConsoleApp;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try(ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml")) {

            LibraryFactory libraryFactory = applicationContext.getBean(LibraryFactory.class);
            List<Library> dictionaries = (List<Library>) applicationContext.getBean("librariesInstance");
            List<String> typesDictionaries = (List<String>) applicationContext.getBean("namesDictionariesInstance");

            List<view.commands.Action> actions = new ArrayList<>();

            actions.add(new ActionReadPairs(dictionaries));
            actions.add(new ActionAddPairs(dictionaries));
            actions.add(new ActionDeletePairs(dictionaries));
            actions.add(new ActionSearchPair(dictionaries));
            actions.add(new ActionExitLibrary(dictionaries));

            ConsoleApp consoleApp = new ConsoleApp(typesDictionaries, actions);
            consoleApp.work();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

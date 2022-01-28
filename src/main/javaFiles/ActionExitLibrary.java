package src.main.javaFiles;

<<<<<<< Updated upstream:src/main/javaFiles/ActionExitLibrary.java
import java.io.IOException;

public class ActionExitLibrary implements Action{
    ConsoleApp consoleApp;
=======
public class ActionExitLibrary implements Action {
    private final String INFO = "5.Finish working with this dictionary\n";
    private final String END_WORK = "Finished work with ";
>>>>>>> Stashed changes:src/main/java/ActionExitLibrary.java

    @Override
    public String getINFO() {
        return INFO;
    }

<<<<<<< Updated upstream:src/main/javaFiles/ActionExitLibrary.java
    @Override
    public void execute() throws IOException {
        consoleApp.work();
=======
    public void execute(Object actionObject) {
        Library library = (Library) actionObject;
        System.out.println(END_WORK + library.getNameLibrary());
>>>>>>> Stashed changes:src/main/java/ActionExitLibrary.java
    }
}

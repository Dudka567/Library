package src.main.javaFiles;

import java.io.IOException;

public class ActionAddPairs implements Action {
<<<<<<< Updated upstream:src/main/javaFiles/ActionAddPairs.java
    private LibraryFunctionally library;

    public ActionAddPairs(LibraryFunctionally library) {
        this.library = library;
    }

    @Override
    public void execute() throws IOException {
=======
    private final String INFO = "2.Add an entry\n";

    @Override
    public String getINFO() {
        return INFO;
    }

    @Override
    public void execute(Object actionObject) {
        Library library = (Library) actionObject;
>>>>>>> Stashed changes:src/main/java/ActionAddPairs.java
        System.out.print(ConsoleConstants.INPUT_KEY);
        String tempKey = ConsoleConstants.user.next();
        System.out.print(ConsoleConstants.INPUT_VALUE);
        String tempValue = ConsoleConstants.user.next();
        System.out.println(library.addPair(tempKey, tempValue));
    }
}

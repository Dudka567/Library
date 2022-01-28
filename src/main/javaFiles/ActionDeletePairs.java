package src.main.javaFiles;

import java.io.IOException;

public class ActionDeletePairs implements Action {
<<<<<<< Updated upstream:src/main/javaFiles/ActionDeletePairs.java
    private LibraryFunctionally library;

    public ActionDeletePairs(LibraryFunctionally library) {
        this.library = library;
    }

    @Override
    public void execute() throws IOException {
=======
    private final String INFO = "3.Delete an entry\n";

    @Override
    public String getINFO() {
        return INFO;
    }

    public void execute(Object actionObject) {
        Library library = (Library) actionObject;
>>>>>>> Stashed changes:src/main/java/ActionDeletePairs.java
        System.out.print(ConsoleConstants.INPUT_KEY);
        String tempKey = ConsoleConstants.user.next();
        System.out.println(library.deletePair(tempKey));
    }
}

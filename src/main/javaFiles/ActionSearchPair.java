package src.main.javaFiles;

import java.io.IOException;

public class ActionSearchPair implements Action {
<<<<<<< Updated upstream:src/main/javaFiles/ActionSearchPair.java
    private LibraryFunctionally library;

    public ActionSearchPair(LibraryFunctionally library) {
        this.library = library;
    }

    @Override
    public void execute() throws IOException {
=======
    private final String INFO = "4.Search records by key\n";

    @Override
    public String getINFO() {
        return INFO;
    }

    @Override
    public void execute(Object actionObject) {
        Library library = (Library) actionObject;
>>>>>>> Stashed changes:src/main/java/ActionSearchPair.java
        System.out.print(ConsoleConstants.INPUT_KEY);
        String tempKey = ConsoleConstants.user.next();
        System.out.println(library.searchPair(tempKey));
    }
}

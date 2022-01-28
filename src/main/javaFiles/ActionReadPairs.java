package src.main.javaFiles;

import java.io.IOException;

public class ActionReadPairs implements Action {
<<<<<<< Updated upstream:src/main/javaFiles/ActionReadPairs.java
    private LibraryFunctionally library;

    public ActionReadPairs(LibraryFunctionally library) {
        this.library = library;
    }

    @Override
    public void execute() throws IOException {
=======
    private final String INFO = "1.Show the contents of the dictionary\n";

    @Override
    public String getINFO() {
        return INFO;
    }

    @Override
    public void execute(Object actionObject) {
        Library library = (Library) actionObject;
>>>>>>> Stashed changes:src/main/java/ActionReadPairs.java
        library.readPairs();
        for (String lineKey : library.getLocalDictionary().keySet()) {
            System.out.println(ConsoleConstants.KEY + lineKey + ConsoleConstants.CHAR_SPACE + ConsoleConstants.VALUE + library.getLocalDictionary().get(lineKey));
        }
    }
}

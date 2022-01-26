package src.main.javaFiles;

import java.io.IOException;

public class ActionReadPairs implements Action {
    private LibraryFunctionally library;

    public ActionReadPairs(LibraryFunctionally library) {
        this.library = library;
    }

    @Override
    public void execute() throws IOException {
        library.readPairs();
        for (String lineKey : library.getLocalDictionary().keySet()) {
            System.out.println(ConsoleConstants.KEY + lineKey + ConsoleConstants.CHAR_SPACE + ConsoleConstants.VALUE + library.getLocalDictionary().get(lineKey));
        }
    }
}

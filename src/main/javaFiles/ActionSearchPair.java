package src.main.javaFiles;

import java.io.IOException;

public class ActionSearchPair implements Action {
    private LibraryFunctionally library;

    public ActionSearchPair(LibraryFunctionally library) {
        this.library = library;
    }

    @Override
    public void execute() throws IOException {
        System.out.print(ConsoleConstants.INPUT_KEY);
        String tempKey = ConsoleConstants.user.next();
        System.out.println(library.searchPair(tempKey));
    }
}

package src.main.javaFiles;

import java.io.IOException;

public class ActionAddPairs implements Action {
    private LibraryFunctionally library;

    public ActionAddPairs(LibraryFunctionally library) {
        this.library = library;
    }

    @Override
    public void execute() throws IOException {
        System.out.print(ConsoleConstants.INPUT_KEY);
        String tempKey = ConsoleConstants.user.next();
        System.out.print(ConsoleConstants.INPUT_VALUE);
        String tempValue = ConsoleConstants.user.next();
        System.out.println(library.addPair(tempKey, tempValue));
    }
}

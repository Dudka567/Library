package src.main.java;

public class ActionReadPairs implements Action {
    private Library library;

    public ActionReadPairs(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        library.readPairs();
        for (String lineKey : library.getLocalDictionary().keySet()) {
            System.out.println(ConsoleConstants.KEY + lineKey + ConsoleConstants.CHAR_SPACE + ConsoleConstants.VALUE + library.getLocalDictionary().get(lineKey));
        }
    }
}

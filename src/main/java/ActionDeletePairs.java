package src.main.java;

public class ActionDeletePairs implements Action {
    private final String INFO = "3.Delete an entry\n";

    @Override
    public String getINFO() {
        return INFO;
    }

    public void execute(Object actionObject) {
        Library library = (Library) actionObject;
        System.out.print(ConsoleConstants.INPUT_KEY);
        String tempKey = ConsoleConstants.user.next();
        System.out.println(library.deletePair(tempKey));
    }
}

package src.main.java;

public class ActionDeletePairs implements Action {
    private Library library;

    public ActionDeletePairs(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.print(ConsoleConstants.INPUT_KEY);
        String tempKey = ConsoleConstants.user.next();
        System.out.println(library.deletePair(tempKey));
    }
}

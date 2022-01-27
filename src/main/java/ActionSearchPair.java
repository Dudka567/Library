package src.main.java;

public class ActionSearchPair implements Action {
    private Library library;

    public ActionSearchPair(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.print(ConsoleConstants.INPUT_KEY);
        String tempKey = ConsoleConstants.user.next();
        System.out.println(library.searchPair(tempKey));
    }
}

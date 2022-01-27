package src.main.java;

public class ActionAddPairs implements Action {
    private Library library;

    public ActionAddPairs(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.print(ConsoleConstants.INPUT_KEY);
        String tempKey = ConsoleConstants.user.next();
        System.out.print(ConsoleConstants.INPUT_VALUE);
        String tempValue = ConsoleConstants.user.next();
        System.out.println(library.addPair(tempKey, tempValue));
    }
}

package src.main.java;

public class Main {
    public static void main(String[] args) {

        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        ConsoleApp consoleApp = new ConsoleApp(libraryFactory);
        consoleApp.work();

    }
}

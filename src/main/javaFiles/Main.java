package src.main.javaFiles;


public class Main {
    public static void main(String[] args) {
        try {
            LibraryFactory libraryFactory = new LibraryFactory(new Config());
            ConsoleApp consoleApp = new ConsoleApp(libraryFactory);
            consoleApp.work();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

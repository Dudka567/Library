package src.main.javaFiles;


import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            LibraryFactory libraryFactory = new LibraryFactory(new ConfigManager());
            ConsoleApp consoleApp = new ConsoleApp(libraryFactory);
            consoleApp.work();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

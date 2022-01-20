package src.main.javaFiles; 

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LibraryFactoryFunctionally libraryFactory = new LibraryFactory();
        ConsoleAppFunctionally consoleApp = new ConsoleApp(libraryFactory);
        consoleApp.work();
    }
}

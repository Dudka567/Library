package src.main.javaFiles; 
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        FileManager manager = new FileManager(false);
        LibraryFactory factory = new LibraryFactory(manager);
        ConsoleApp consoleApp = new ConsoleApp(manager, factory);
        consoleApp.work();
    }
}

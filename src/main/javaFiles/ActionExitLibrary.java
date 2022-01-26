package src.main.javaFiles;

import java.io.IOException;

public class ActionExitLibrary implements Action{
    ConsoleApp consoleApp;

    public ActionExitLibrary(ConsoleApp consoleApp) {
        this.consoleApp = consoleApp;
    }

    @Override
    public void execute() throws IOException {
        consoleApp.work();
    }
}

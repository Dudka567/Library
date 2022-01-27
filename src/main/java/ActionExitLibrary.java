package src.main.java;

public class ActionExitLibrary implements Action {
    ConsoleApp consoleApp;

    public ActionExitLibrary(ConsoleApp consoleApp) {
        this.consoleApp = consoleApp;
    }

    @Override
    public void execute() {
        consoleApp.work();
    }
}

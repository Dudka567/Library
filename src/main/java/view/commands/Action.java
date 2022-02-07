package view.commands;

public interface Action {
    String getINFO();

    void execute(Object actionObject);
}

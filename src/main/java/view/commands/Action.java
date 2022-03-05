package view.commands;

public interface Action {
    String getTitle();

    void setPosition(Integer position);

    void execute(String typeLibrary);
}

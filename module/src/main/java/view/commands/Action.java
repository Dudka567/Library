package src.main.java.view.commands;

public interface Action {
    String getTitle();

    void setPosition(Integer position);

    Integer getPosition();

    void execute(String typeLibrary);
}

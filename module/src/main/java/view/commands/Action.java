package src.main.java.view.commands;

import lombok.NonNull;

public interface Action {
    String getINFO();

    void execute(@NonNull Object actionObject);
}
